package org.springframework.social.salesforce.api.impl;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.social.salesforce.api.QueryResult;
import org.springframework.social.salesforce.api.ResultItem;
import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

/**
 * Test cases for the Query Template.
 * 
 * @author Umut Utkan
 */
public class QueryTemplateTest extends AbstractSalesforceTest {
    
    @Test
    public void withTimestamps() {
        this.mockServer.expect(requestTo(VERSION_URL + "/query?q=2013-11-16T22:36:06%2B0000"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("query-simple.json"), this.responseHeaders));
        this.salesforce.queryOperations().query("2013-11-16T22:36:06+0000"); // make sure that + gets converted to %2B
    }

    @Test
    public void simpleQuery() {
        this.mockServer.expect(requestTo(VERSION_URL + "/query?q=SELECT%20Id,%20Name,%20BillingCity%20FROM%20Account"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("query-simple.json"), this.responseHeaders));
        final QueryResult result = this.salesforce.queryOperations().query("SELECT Id, Name, BillingCity FROM Account");

        assertThat(result.getRecords(), hasSize(12));
        assertThat(result.getNextRecordsUrl(), equalTo("/services/data/v23.0/query/01gD0000002HU6KIAW-2000"));
        assertThat(result.getNextRecordsToken(), equalTo("01gD0000002HU6KIAW-2000"));
        for (ResultItem item : result.getRecords()) {
            assertThat(item.getType(), equalTo("Account"));
        }
        final Map attrFirst = result.getRecords().get(0).getAttributes();
        assertThat((String)attrFirst.get("Id"), equalTo("001A000000df63xIAA"));
        assertThat((String)attrFirst.get("Name"), equalTo("GenePoint"));
        assertThat((String)attrFirst.get("BillingCity"), equalTo("Mountain View"));
    }

    @Test
    public void whereQuery() {
        this.mockServer
                .expect(requestTo(VERSION_URL + "/query?q=SELECT%20Id%20FROM%20Contact%20WHERE%20Name%20LIKE%20'U%25'%20AND%20MailingCity%20%3D%20'Istanbul'"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("query-where.json"), this.responseHeaders));
        final QueryResult result = this.salesforce.queryOperations().query("SELECT Id FROM Contact WHERE Name LIKE 'U%' AND MailingCity = 'Istanbul'");

        assertThat(result.getRecords(), hasSize(2));
        assertThat(result.getRecords().get(0).getType(), equalTo("Contact"));
        assertThat(result.getRecords().get(0).getUrl(), equalTo("/services/data/v23.0/sobjects/Contact/003A000000vF6QSIA0"));
        assertThat((String)result.getRecords().get(0).getAttributes().get("Id"), equalTo("003A000000vF6QSIA0"));
        assertThat(result.getRecords().get(1).getType(), equalTo("Contact"));
        assertThat(result.getRecords().get(1).getUrl(), equalTo("/services/data/v23.0/sobjects/Contact/003A000000vF6QXIA0"));
        assertThat((String)result.getRecords().get(1).getAttributes().get("Id"), equalTo("003A000000vF6QXIA0"));
    }

    @Test
    public void child2parentQuery() {
        this.mockServer
                .expect(requestTo(VERSION_URL + "/query?q=SELECT%20Contact.FirstName,%20Contact.Account.Name%20FROM%20Contact"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("query-child2parent.json"), this.responseHeaders));
        final QueryResult result = this.salesforce.queryOperations().query("SELECT Contact.FirstName, Contact.Account.Name FROM Contact");

        assertThat(result.getRecords(), hasSize(22));
        for (ResultItem item : result.getRecords()) {
            assertThat(item.getType(), equalTo("Contact"));
        }
        assertThat((String)result.getRecords().get(0).getAttributes().get("FirstName"), equalTo("Umut"));
        assertThat(result.getRecords().get(0).getAttributes().get("Account"), nullValue());
        assertThat((String)result.getRecords().get(1).getAttributes().get("FirstName"), equalTo("Utkan"));
        assertThat(result.getRecords().get(1).getAttributes().get("Account"), nullValue());
        assertThat((String)result.getRecords().get(2).getAttributes().get("FirstName"), equalTo("Rose"));
        final ResultItem roseAccount = (ResultItem)result.getRecords().get(2).getAttributes().get("Account");
        assertThat(roseAccount.getType(), equalTo("Account"));
        assertThat(roseAccount.getUrl(), equalTo("/services/data/v23.0/sobjects/Account/001A000000df640IAA"));
        assertThat((String)roseAccount.getAttributes().get("Name"), equalTo("Edge Communications"));
    }

    @Test
    public void countQuery() {
        this.mockServer.expect(requestTo(VERSION_URL + "/query?q=SELECT%20COUNT()%20FROM%20Contact"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("query-count.json"), this.responseHeaders));
        final QueryResult result = this.salesforce.queryOperations().query("SELECT COUNT() FROM Contact");

        assertThat(result.getTotalSize(), equalTo(22));
        assertThat(result.getRecords(), is(empty()));
    }

    @Test
    public void groupByQuery() {
        this.mockServer
                .expect(requestTo(VERSION_URL + "/query?q=SELECT%20LeadSource,%20COUNT(Name)%20FROM%20Lead%20GROUP%20BY%20LeadSource"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("query-groupby.json"), this.responseHeaders));
        final QueryResult result = this.salesforce.queryOperations().query("SELECT LeadSource, COUNT(Name) FROM Lead GROUP BY LeadSource");

        assertThat(result.getRecords(), hasSize(4));
        for (ResultItem item : result.getRecords()) {
            assertThat(item.getType(), equalTo("AggregateResult"));
        }
        assertThat((String)result.getRecords().get(0).getAttributes().get("LeadSource"), equalTo("Web"));
        assertThat((Integer)result.getRecords().get(0).getAttributes().get("expr0"), equalTo(7));
        assertThat((String)result.getRecords().get(1).getAttributes().get("LeadSource"), equalTo("Phone Inquiry"));
        assertThat((Integer)result.getRecords().get(1).getAttributes().get("expr0"), equalTo(4));
    }

    @Test
    public void parent2childQuery() {
        this.mockServer
                .expect(requestTo(VERSION_URL + "/query?q=SELECT%20Name,%20(SELECT%20LastName%20FROM%20Contacts)%20FROM%20Account"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("query-parent2child.json"), this.responseHeaders));
        final QueryResult result = this.salesforce.queryOperations().query("SELECT Name, (SELECT LastName FROM Contacts) FROM Account");

        assertThat(result.getRecords(), hasSize(12));
        for (ResultItem item : result.getRecords()) {
            assertThat(item.getType(), equalTo("Account"));
        }
        assertThat(result.getRecords().get(0).getUrl(), equalTo("/services/data/v23.0/sobjects/Account/001A000000df63xIAA"));
        assertThat((String)result.getRecords().get(0).getAttributes().get("Name"), equalTo("GenePoint"));
        final QueryResult genePointContacts = (QueryResult)result.getRecords().get(0).getAttributes().get("Contacts");
        assertThat(genePointContacts.getRecords(), hasSize(1));
        assertThat(genePointContacts.getRecords().get(0).getType(), equalTo("Contact"));
        assertThat(genePointContacts.getRecords().get(0).getUrl(), equalTo("/services/data/v23.0/sobjects/Contact/003A000000lGE0yIAG"));
        assertThat((String)genePointContacts.getRecords().get(0).getAttributes().get("LastName"), equalTo("Frank"));
    }

}
