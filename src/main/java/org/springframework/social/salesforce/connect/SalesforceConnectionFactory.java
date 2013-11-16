package org.springframework.social.salesforce.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.salesforce.SalesforceConstants.ApiLevel;
import org.springframework.social.salesforce.api.Salesforce;

/**
 * Factory for creating OAuth2-based Salesforce connections.
 * 
 * @author Umut Utkan
 */
public class SalesforceConnectionFactory extends OAuth2ConnectionFactory<Salesforce> {

    public SalesforceConnectionFactory(final String clientId, final String clientSecret, final String authorizeUrl, final String tokenUrl,
            final String instanceUrl, final ApiLevel apiLevel) {
        super("salesforce", new SalesforceServiceProvider(clientId, clientSecret,
                authorizeUrl, tokenUrl, instanceUrl, apiLevel), null);
    }

}
