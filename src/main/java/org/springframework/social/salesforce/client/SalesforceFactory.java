package org.springframework.social.salesforce.client;

import org.springframework.social.salesforce.api.Salesforce;

/**
 * Salesforce template factory for those who want to use salesforce with client login.
 *
 * @author Umut Utkan
 */
public interface SalesforceFactory {

    /**
     * Get a handle to the Salesforce API.
     * 
     * @param username The username
     * @param password The password
     * @param securityToken The API security token
     * @return Salesforce API
     */
    Salesforce create(String username, String password, String securityToken);

}
