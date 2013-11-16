package org.springframework.social.salesforce.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.social.salesforce.SalesforceConstants.Endpoints;
import org.springframework.social.salesforce.api.ChatterOperations;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.api.SalesforceProfile;
import org.springframework.social.salesforce.api.Status;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Default implementation of ChatterOperations.
 * 
 * @author Umut Utkan
 */
public class ChatterTemplate extends AbstractSalesForceOperations<Salesforce> implements ChatterOperations {

    private RestTemplate restTemplate;

    public ChatterTemplate(final Salesforce api, final RestTemplate restTemplate) {
        super(api);
        this.restTemplate = restTemplate;
        configureRestTemplate();
    }

    @Override
    public SalesforceProfile getUserProfile() {
        return getUserProfile("me");
    }

    @Override
    public SalesforceProfile getUserProfile(final String userId) {
        requireAuthorization();
        return this.restTemplate.getForObject(this.api.getBaseUrl() + Endpoints.Chatter.USER_BY_ID,
                SalesforceProfile.class, userId);
    }

    @Override
    public Status getStatus() {
        return getStatus("me");
    }

    @Override
    public Status getStatus(final String userId) {
        requireAuthorization();

        final JsonNode node = this.restTemplate.getForObject(this.api.getBaseUrl() + Endpoints.Chatter.USER_STATUS,
                JsonNode.class, userId);
        return this.api.readObject(node.get("body"), Status.class);
    }

    @Override
    public Status updateStatus(final String message) {
        return updateStatus("me", message);
    }

    @Override
    public Status updateStatus(final String userId, final String message) {
        requireAuthorization();

        final MultiValueMap<String, String> post = new LinkedMultiValueMap<String, String>();
        post.add("text", message);
        final JsonNode node = this.restTemplate.postForObject(this.api.getBaseUrl() + Endpoints.Chatter.USER_STATUS,
                post, JsonNode.class, userId);
        return this.api.readObject(node.get("body"), Status.class);
    }

    /**
     * Adds interceptor to rest template for adding X-Chatter-Entity-Encoding=false header.
     * This header informs Salesforce not to encode special characters and to return as is.
     */
    private void configureRestTemplate() {
        final Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Chatter-Entity-Encoding", "false");

        this.restTemplate.getInterceptors().add(new HeaderAddingInterceptor(headers));
    }

}
