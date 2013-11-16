package org.springframework.social.salesforce.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.salesforce.SalesforceConstants.ApiLevel;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.api.impl.SalesforceTemplate;

/**
 * Salesforce ServiceProvider implementation.
 * 
 * @author Umut Utkan
 */
public class SalesforceServiceProvider extends AbstractOAuth2ServiceProvider<Salesforce> {

    private final String instanceUrl;
    private final ApiLevel apiLevel;
    
    public SalesforceServiceProvider(final String clientId, final String clientSecret, final String authorizeUrl, final String tokenUrl, final String instanceUrl, final ApiLevel apiLevel) {
        super(new SalesforceOAuth2Template(clientId, clientSecret, authorizeUrl, tokenUrl));
        this.instanceUrl = instanceUrl;
        this.apiLevel = apiLevel;
    }

    @Override
    public Salesforce getApi(final String accessToken) {
        return new SalesforceTemplate(this.instanceUrl, this.apiLevel, accessToken);
    }

}
