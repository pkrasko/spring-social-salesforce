package org.springframework.social.salesforce.api.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.springframework.social.salesforce.api.QueryResult;
import org.springframework.social.salesforce.api.SObjectDetail;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.client.BaseSalesforceFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * CLI.
 */
public final class SalesforceCLI {
    
    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.configure(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS, true);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
    
    private SalesforceCLI() {
        
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = null;
        if (args.length > 0) {
            br = new BufferedReader(new FileReader(args[0]));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        System.out.println("Enter the authentication URL [https://login.salesforce.com]: ");
        String url = br.readLine();
        if (!StringUtils.hasText(url)) {
            url = "https://login.salesforce.com";
        }
        url += "/services/oauth2/token";
        System.out.println("Entered: " + url);
        
        System.out.println("Enter your SF client id: ");
        final String clientid = br.readLine();
        System.out.println("Entered: " + clientid);

        System.out.println("Enter your SF client secret: ");
        final String clientSecret = br.readLine();
        System.out.println("Entered: " + clientSecret);

        System.out.println("Enter your SF username: ");
        final String username = br.readLine();
        System.out.println("Entered: " + username);

        System.out.println("Enter your SF password: ");
        final String password = br.readLine();
        System.out.println("Entered: " + password);

        System.out.println("Enter your secret token: ");
        final String secretToken = br.readLine();
        System.out.println("Entered: " + secretToken);

        final BaseSalesforceFactory factory = new BaseSalesforceFactory(clientid, clientSecret);
        factory.setAuthorizeUrl(url);
        final Salesforce template = factory.create(username, password, secretToken);
        
        final QueryResult r = template.queryOperations().query("select jp.id, jp.hiring_manager__r.id, jp.hiring_manager__r.email, jp.hiring_manager__r.name, "
                + "jp.Title__c, jp.Description__c, jp.skills__c, jp.state__c, jp.bonus__c, jp.requisitionNumber__c from Job_Posting__c jp where state__c ='open'");
        
        
        System.out.println(toJsonFormat(r));
        
        final List<Map> sobjects = template.sObjectsOperations().getSObjects();
        for (Map m : sobjects) {
            final String sobjectName = (String)m.get("name");
            if (sobjectName != null && sobjectName.equals("Organization")) {
                System.out.println("---- Access to Organization ----");
                final SObjectDetail detail = template.sObjectsOperations().describeSObject("Organization");
                System.out.println("Is Retrievable: " + detail.isRetrieveable());
                System.out.println("Is List viewable: " + detail.isListviewable());
                System.out.println("Is Queryable: " + detail.isQueryable());
                System.out.println("Is Searchable: " + detail.isSearchable());
            }
            if (sobjectName != null && sobjectName.equals("User")) {
                System.out.println("---- Access to User ----");
                final SObjectDetail detail = template.sObjectsOperations().describeSObject("User");
                System.out.println("Is Retrievable: " + detail.isRetrieveable());
                System.out.println("Is List viewable: " + detail.isListviewable());
                System.out.println("Is Queryable: " + detail.isQueryable());
                System.out.println("Is Searchable: " + detail.isSearchable());
            }
        }
        
    }
    
    private static String toJsonFormat(final Object obj) {
        try {
            final StringWriter w = new StringWriter();
            mapper.writeValue(w, obj);
            return w.toString();
        } catch (final IOException exn) {
            throw new IllegalStateException(exn);
        }
    }

}
