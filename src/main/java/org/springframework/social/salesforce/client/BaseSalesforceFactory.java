package org.springframework.social.salesforce.client;

import java.util.Map;

import org.springframework.social.salesforce.SalesforceConstants.ApiLevel;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.api.impl.SalesforceTemplate;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Default implementation of SalesforceFactory.
 *
 * @author Umut Utkan
 */
public class BaseSalesforceFactory implements SalesforceFactory {

    private static final String DEFAULT_AUTH_URL = "https://login.salesforce.com/services/oauth2/token";

    private String clientId;

    private String clientSecret;

    private String authorizeUrl = DEFAULT_AUTH_URL;

    private RestTemplate restTemplate;


    public BaseSalesforceFactory(final String clientId, final String clientSecret) {
        this(clientId, clientSecret, createRestTemplate());
    }

    public BaseSalesforceFactory(final String clientId, final String clientSecret, final RestTemplate restTemplate) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.restTemplate = restTemplate;
    }


    public void setAuthorizeUrl(final String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    @Override
    public Salesforce create(final String username, final String password, final String securityToken) {
        final MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "password");
        map.add("client_id", this.clientId);
        map.add("client_secret", this.clientSecret);
        map.add("username", username);
        map.add("password", password + (securityToken == null ? "" : securityToken));

        final Map<String, String> token = this.restTemplate.postForObject(this.authorizeUrl, map, Map.class);
        return new SalesforceTemplate(token.get("instance_url"), ApiLevel.V27, token.get("access_token"));
    }

    private static RestTemplate createRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(ClientHttpRequestFactorySelector.getRequestFactory());
        restTemplate.setErrorHandler(new ErrorHandler());
        return restTemplate;
    }

}
