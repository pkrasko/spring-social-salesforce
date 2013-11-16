package org.springframework.social.salesforce.api.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.salesforce.SalesforceConstants.ApiLevel;
import org.springframework.social.test.client.MockRestServiceServer;
import org.testng.annotations.BeforeMethod;

/**
 * Base test, handles setup.
 * 
 * @author Umut Utkan
 */
public abstract class AbstractSalesforceTest {

    protected static final String BASE_URL = "https://na7.salesforce.com/services/data";
    protected static final String VERSION_PATH = "/services/data/v27.0";
    protected static final String VERSION_URL = BASE_URL + "/v27.0";
    
    protected SalesforceTemplate salesforce;

    protected SalesforceTemplate unauthorizedSalesforce;

    protected MockRestServiceServer mockServer;

    protected HttpHeaders responseHeaders;

    @BeforeMethod
    public void setUp() {
        this.salesforce = new SalesforceTemplate("https://na7.salesforce.com", ApiLevel.V27, "ACCESS_TOKEN");
        this.mockServer = MockRestServiceServer.createServer(this.salesforce.getRestTemplate());
        this.responseHeaders = new HttpHeaders();
        this.responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.unauthorizedSalesforce = new SalesforceTemplate("https://na7.salesforce.com", ApiLevel.V27);
        // create a mock server just to avoid hitting real twitter if something gets past the authorization check
        MockRestServiceServer.createServer(this.unauthorizedSalesforce.getRestTemplate());
    }

    protected Resource loadResource(final String name) {
        return new ClassPathResource("/" + name, getClass());
    }

}
