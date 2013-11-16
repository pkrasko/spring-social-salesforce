package org.springframework.social.salesforce.api.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpMethod;
import org.springframework.social.salesforce.api.SObjectDetail;
import org.springframework.social.salesforce.api.SObjectSummary;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

/**
 * Test cases for the sobject template.
 * 
 * @author Umut Utkan
 */
public class SObjectsTemplateTest extends AbstractSalesforceTest {

    @Test
    public void getSObjects() {
        this.mockServer.expect(requestTo(VERSION_URL + "/sobjects"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("sobjects.json"), this.responseHeaders));
        final List<Map> sobjects = this.salesforce.sObjectsOperations().getSObjects();
        assertThat(sobjects, hasSize(160));
        assertThat((String)sobjects.get(0).get("name"), equalTo("Account"));
        assertThat((String)sobjects.get(0).get("label"), equalTo("Account"));
        assertThat((String)sobjects.get(0).get("labelPlural"), equalTo("Accounts"));
        assertThat((String)((Map)sobjects.get(0).get("urls")).get("sobject"), equalTo("/services/data/v23.0/sobjects/Account"));
    }

    @Test
    public void getSObject() {
        this.mockServer.expect(requestTo(VERSION_URL + "/sobjects/Account"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("account.json"), this.responseHeaders));
        final SObjectSummary account = this.salesforce.sObjectsOperations().getSObject("Account");
        assertThat(account, notNullValue());
        assertThat(account.getName(), equalTo("Account"));
        assertThat(account.getLabel(), equalTo("Account"));
        assertThat(account.isUndeletable(), is(equalTo(true)));
        assertThat(account.getKeyPrefix(), equalTo("001"));
        assertThat(account.isCustom(), is(equalTo(false)));
        assertThat(account.getUrls().get("rowTemplate"), equalTo("/services/data/v23.0/sobjects/Account/{ID}"));
    }

    @Test
    public void describeSObject() {
        this.mockServer.expect(requestTo(VERSION_URL + "/sobjects/Account/describe"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("account_desc.json"), this.responseHeaders));
        final SObjectDetail account = this.salesforce.sObjectsOperations().describeSObject("Account");
        assertThat(account, notNullValue());
        assertThat(account.getName(), equalTo("Account"));
        assertThat(account.getLabel(), equalTo("Account"));
        assertThat(account.getFields(), hasSize(45));
        assertThat(account.getFields().get(0).getName(), equalTo("Id"));
        assertThat(account.getRecordTypeInfos(), hasSize(1));
        assertThat(account.getRecordTypeInfos().get(0).getName(), equalTo("Master"));
        assertThat(account.getChildRelationships(), hasSize(36));
        assertThat(account.getChildRelationships().get(0).getField(), equalTo("ParentId"));
    }

    @Test
    public void getBlob() throws IOException {
        this.mockServer.expect(requestTo(VERSION_URL + "/sobjects/Account/xxx/avatar"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(new ByteArrayResource("does-not-matter".getBytes("UTF-8")), this.responseHeaders));
        final BufferedReader reader = new BufferedReader(new InputStreamReader(this.salesforce.sObjectsOperations().getBlob("Account", "xxx", "avatar")));
        assertThat(reader.readLine(), equalTo("does-not-matter"));
    }

    @Test
    public void testCreate() throws IOException {
        this.mockServer.expect(requestTo(VERSION_URL + "/sobjects/Lead"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withResponse(new ByteArrayResource("{\"Id\" : \"1234\"}".getBytes("UTF-8")), this.responseHeaders));
        final Map<String, String> fields = new HashMap<String, String>();
        fields.put("LastName", "Doe");
        fields.put("FirstName", "John");
        fields.put("Company", "Acme, Inc.");
        final Map<?, ?> result = this.salesforce.sObjectsOperations().create("Lead", fields);
        assertThat(result, notNullValue());
        assertThat(result.keySet(), hasSize(1));
        assertThat((String)result.get("Id"), equalTo("1234"));
    }

}
