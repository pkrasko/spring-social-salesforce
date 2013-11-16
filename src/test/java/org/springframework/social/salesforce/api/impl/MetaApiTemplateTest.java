package org.springframework.social.salesforce.api.impl;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.social.salesforce.SalesforceConstants.ApiLevel;
import org.springframework.social.salesforce.api.ApiVersion;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

/**
 * Meta api test cases.
 * 
 * @author Umut Utkan
 */
public class MetaApiTemplateTest extends AbstractSalesforceTest {

    @Test
    public void getApiVersions() {
        this.mockServer.expect(requestTo(BASE_URL))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("versions.json"), this.responseHeaders));
        final List<ApiVersion> versions = this.salesforce.apiOperations().getVersions();
        assertThat(versions, hasSize(4));
        assertThat(versions.get(3).getLabel(), equalTo("Winter '12"));
        assertThat(versions.get(3).getVersion(), equalTo("23.0"));
        assertThat(versions.get(3).getUrl(), equalTo("/services/data/v23.0"));
    }

    @Test
    public void getServices() {
        this.mockServer.expect(requestTo(VERSION_URL))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("services.json"), this.responseHeaders));
        final Map<String, String> services = this.salesforce.apiOperations().getServices(ApiLevel.V27.getVersion());
        assertThat(services, notNullValue());
        assertThat(services.keySet(), hasSize(6));
        assertThat(services.get("sobjects"), equalTo("/services/data/v27.0/sobjects"));
        assertThat(services.get("chatter"), equalTo("/services/data/v27.0/chatter"));
    }

}
