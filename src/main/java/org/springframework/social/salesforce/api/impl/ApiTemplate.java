package org.springframework.social.salesforce.api.impl;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.social.salesforce.SalesforceConstants.Endpoints;
import org.springframework.social.salesforce.api.ApiOperations;
import org.springframework.social.salesforce.api.ApiVersion;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Default implementation of ApiOperations.
 * 
 * @author Umut Utkan
 */
public class ApiTemplate extends AbstractSalesForceOperations<Salesforce> implements ApiOperations {

    private final RestTemplate restTemplate;

    public ApiTemplate(final Salesforce api, final RestTemplate restTemplate) {
        super(api);
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ApiVersion> getVersions() {
        final URI uri = URIBuilder.fromUri(this.api.getInstanceUrl() + Endpoints.Api.VERSIONS).build();
        final JsonNode dataNode = this.restTemplate.getForObject(uri, JsonNode.class);
        return this.api.readList(dataNode, ApiVersion.class);
    }

    @Override
    public Map<String, String> getServices(final String version) {
        requireAuthorization();
        return this.restTemplate.getForObject(this.api.getInstanceUrl() + Endpoints.Api.SERVICES, Map.class, version);
    }
}
