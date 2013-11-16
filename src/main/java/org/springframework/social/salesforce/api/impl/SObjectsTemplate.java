package org.springframework.social.salesforce.api.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.salesforce.SalesforceConstants.Endpoints;
import org.springframework.social.salesforce.api.SObjectDetail;
import org.springframework.social.salesforce.api.SObjectOperations;
import org.springframework.social.salesforce.api.SObjectSummary;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.StringUtils;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Default implementation of SObjectOperations.
 * 
 * @author Umut Utkan
 */
public class SObjectsTemplate extends AbstractSalesForceOperations<Salesforce> implements SObjectOperations {

    private RestTemplate restTemplate;

    public SObjectsTemplate(final Salesforce api, final RestTemplate restTemplate) {
        super(api);
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Map> getSObjects() {
        requireAuthorization();
        final JsonNode dataNode = this.restTemplate.getForObject(this.api.getBaseUrl() + Endpoints.SObjects.ROOT, JsonNode.class);
        return this.api.readList(dataNode.get("sobjects"), Map.class);
    }

    @Override
    public SObjectSummary getSObject(final String name) {
        requireAuthorization();
        final JsonNode node = this.restTemplate.getForObject(this.api.getBaseUrl() + Endpoints.SObjects.BY_NAME, JsonNode.class, name);
        return this.api.readObject(node.get("objectDescribe"), SObjectSummary.class);
    }

    @Override
    public SObjectDetail describeSObject(final String name) {
        requireAuthorization();
        return this.restTemplate.getForObject(this.api.getBaseUrl() + Endpoints.SObjects.DESCRIBE_BY_NAME, SObjectDetail.class, name);
    }

    @Override
    public Map getRow(final String name, final String id, final String... fields) {
        requireAuthorization();
        final String uriPath = Endpoints.buildEndpoint(this.api.getBaseUrl() + Endpoints.SObjects.BY_ROW, name, id);
        final URIBuilder builder = URIBuilder.fromUri(uriPath);
        if (fields.length > 0) {
            builder.queryParam("fields", StringUtils.arrayToCommaDelimitedString(fields));
        }
        return this.restTemplate.getForObject(builder.build(), Map.class);
    }

    @Override
    public InputStream getBlob(final String name, final String id, final String field) {
        requireAuthorization();
        return this.restTemplate.execute(this.api.getBaseUrl() + Endpoints.SObjects.BY_BLOB,
                HttpMethod.GET, null, new ResponseExtractor<InputStream>() {

                    @Override
                    public InputStream extractData(final ClientHttpResponse response) throws IOException {
                        return response.getBody();
                    }
                }, name, id, field);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Map<?, ?> create(final String name, final Map<String, String> fields) {
        requireAuthorization();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Map> entity = new HttpEntity<Map>(fields, headers);
        return this.restTemplate.postForObject(this.api.getBaseUrl() + Endpoints.SObjects.BY_NAME, entity, Map.class, name);
    }

}
