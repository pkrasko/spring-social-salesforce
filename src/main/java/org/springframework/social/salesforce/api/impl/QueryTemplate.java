package org.springframework.social.salesforce.api.impl;

import java.net.URI;

import org.springframework.social.salesforce.SalesforceConstants.Endpoints;
import org.springframework.social.salesforce.api.QueryOperations;
import org.springframework.social.salesforce.api.QueryResult;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Default implementation of QueryOperations.
 * 
 * @author Umut Utkan
 */
public class QueryTemplate extends AbstractSalesForceOperations<Salesforce> implements QueryOperations {

    private RestTemplate restTemplate;

    public QueryTemplate(final Salesforce api, final RestTemplate restTemplate) {
        super(api);
        this.restTemplate = restTemplate;
    }

    @Override
    public QueryResult query(final String query) {
        requireAuthorization();
        final URI uri = UriComponentsBuilder.fromHttpUrl(this.api.getBaseUrl()).path(Endpoints.Query.ROOT).queryParam("q", query).build().toUri();
        return this.restTemplate.getForObject(uri, QueryResult.class);
    }

    @Override
    public QueryResult nextPage(final String pathOrToken) {
        requireAuthorization();
        if (pathOrToken.contains("/")) {
            return this.restTemplate.getForObject(this.api.getBaseUrl() + pathOrToken, QueryResult.class);
        }
        
        final URI uri = UriComponentsBuilder.fromHttpUrl(this.api.getBaseUrl()).path(Endpoints.Query.NEXT_PAGE).buildAndExpand(pathOrToken).toUri();
        return this.restTemplate.getForObject(uri, QueryResult.class);
    }
}
