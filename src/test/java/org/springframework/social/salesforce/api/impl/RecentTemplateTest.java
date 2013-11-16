package org.springframework.social.salesforce.api.impl;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.social.salesforce.api.ResultItem;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

/**
 * Test cases for the recent template.
 * 
 * @author Umut Utkan
 */
public class RecentTemplateTest extends AbstractSalesforceTest {

    @Test
    public void search() {
        this.mockServer.expect(requestTo(VERSION_URL + "/recent"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("recent.json"), this.responseHeaders));
        final List<ResultItem> items = this.salesforce.recentOperations().recent();
        assertThat(items, hasSize(9));
        assertThat(items.get(0).getType(), equalTo("User"));
        assertThat(items.get(0).getUrl(), equalTo("/services/data/v23.0/sobjects/User/005A0000001cRuvIAE"));
        assertThat((String)items.get(0).getAttributes().get("Id"), equalTo("005A0000001cRuvIAE"));
        assertThat((String)items.get(0).getAttributes().get("Name"), equalTo("Umut Utkan"));
    }

}
