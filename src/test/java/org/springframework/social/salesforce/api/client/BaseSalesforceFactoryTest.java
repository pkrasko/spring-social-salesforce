package org.springframework.social.salesforce.api.client;


import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.client.BaseSalesforceFactory;
import org.springframework.social.test.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

/**
 * Test.
 * 
 * @author Umut Utkan
 */
public class BaseSalesforceFactoryTest {

    @Test
    public void testClientLogin() {
        final RestTemplate restTemplate = new RestTemplate();
        final MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        mockServer.expect(requestTo("https://login.salesforce.com/services/oauth2/token"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(body("grant_type=password&client_id=client-id&client_secret=client-secret&username=my-username&password=my-passwordsecurity-token"))
                .andRespond(withResponse(new ClassPathResource("/client-token.json", getClass()), responseHeaders));

        final Salesforce template = new BaseSalesforceFactory("client-id", "client-secret", restTemplate)
                .create("my-username", "my-password", "security-token");
        
        assertThat(template, notNullValue());
    }

}
