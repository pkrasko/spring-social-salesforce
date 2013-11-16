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
 * Test cases for the search template.
 * 
 * @author Umut Utkan
 */
public class SearchTemplateTest extends AbstractSalesforceTest {

    @Test
    public void search() {
        this.mockServer.expect(requestTo(VERSION_URL + "/search?q=FIND+%7Bxxx*%7D+IN+ALL+FIELDS+RETURNING+Contact%2C+Account"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("search.json"), this.responseHeaders));
        final List<ResultItem> results = this.salesforce.searchOperations().search("FIND {xxx*} IN ALL FIELDS RETURNING Contact, Account");
        assertThat(results, hasSize(4));
        assertThat(results.get(0).getType(), equalTo("Contact"));
        assertThat(results.get(1).getType(), equalTo("Contact"));
        assertThat(results.get(2).getType(), equalTo("Account"));
        assertThat(results.get(3).getType(), equalTo("Account"));
    }

}
