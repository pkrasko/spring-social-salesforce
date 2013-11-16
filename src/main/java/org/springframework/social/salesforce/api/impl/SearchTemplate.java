package org.springframework.social.salesforce.api.impl;

import java.net.URI;
import java.util.List;

import org.springframework.social.salesforce.SalesforceConstants.Endpoints;
import org.springframework.social.salesforce.api.ResultItem;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.api.SearchOperations;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Default implementation of SearchOperations.
 * 
 * @author Umut Utkan
 */
public class SearchTemplate extends AbstractSalesForceOperations<Salesforce> implements SearchOperations {

    private RestTemplate restTemplate;

    public SearchTemplate(final Salesforce api, final RestTemplate restTemplate) {
        super(api);
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ResultItem> search(final String soslQuery) {
        requireAuthorization();
        final URI uri = URIBuilder.fromUri(this.api.getBaseUrl() + Endpoints.Search.ROOT).queryParam("q", soslQuery).build();
        final JsonNode arr = this.restTemplate.getForObject(uri, JsonNode.class);
        return this.api.readList(arr, ResultItem.class);
    }

}
