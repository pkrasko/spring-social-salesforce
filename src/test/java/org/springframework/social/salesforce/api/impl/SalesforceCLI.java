/*
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.springframework.social.salesforce.api.SObjectDetail;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.client.BaseSalesforceFactory;
import org.springframework.util.StringUtils;


/**
 * CLI.
 */
public final class SalesforceCLI {
    
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

}
