package org.springframework.social.salesforce.api.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.salesforce.SalesforceConstants;
import org.springframework.social.salesforce.SalesforceConstants.ApiLevel;
import org.springframework.social.salesforce.SalesforceConstants.Endpoints;
import org.springframework.social.salesforce.api.ApiOperations;
import org.springframework.social.salesforce.api.ChatterOperations;
import org.springframework.social.salesforce.api.QueryOperations;
import org.springframework.social.salesforce.api.RecentOperations;
import org.springframework.social.salesforce.api.SObjectOperations;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.api.SearchOperations;
import org.springframework.social.salesforce.api.StandardObjectOperations;
import org.springframework.social.salesforce.api.impl.json.SalesforceModule;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Default implementation of Salesforce. This is the main entry point for all the operations that can be performed on
 * Salesforce.
 * 
 * @author Umut Utkan
 */
public class SalesforceTemplate extends AbstractOAuth2ApiBinding implements Salesforce {

    private final String instanceUrl;
    private final String baseUrl;
    
    private ObjectMapper objectMapper;
    private ApiOperations apiOperations;
    private ChatterOperations chatterOperations;
    private QueryOperations queryOperations;
    private RecentOperations recentOperations;
    private SearchOperations searchOperations;
    private SObjectOperations sObjectsOperations;
    private StandardObjectOperations standardObjectOperations;

    /**
     * Create the template without an OAuth access token; you'll only be able to access
     * unprotected resources.
     * 
     * @param instanceUrl The Salesforce instance url
     * @param apiLevel The Salesforce API level.
     */
    public SalesforceTemplate(final String instanceUrl, final ApiLevel apiLevel) {
        this.instanceUrl = instanceUrl;
        this.baseUrl = createBaseUrl(instanceUrl, apiLevel);
        initialize();
    }

    /**
     * Create the template with the OAuth access token, allowing you to access protected resources.
     * 
     * @param instanceUrl The Salesforce instance url
     * @param apiLevel The Salesforce API level.
     * @param accessToken The OAuth access token
     */
    public SalesforceTemplate(final String instanceUrl, final ApiLevel apiLevel, final String accessToken) {
        super(accessToken);
        this.instanceUrl = instanceUrl;
        this.baseUrl = createBaseUrl(instanceUrl, apiLevel);
        initialize();
    }
    
    private static String createBaseUrl(final String instanceUrl, final ApiLevel apiLevel) {
        return instanceUrl + Endpoints.buildEndpoint(Endpoints.Api.SERVICES, apiLevel.getVersion());
    }

    @Override
    protected OAuth2Version getOAuth2Version() {
        return OAuth2Version.DRAFT_10;
    }

    @Override
    public ApiOperations apiOperations() {
        return this.apiOperations;
    }

    @Override
    public ChatterOperations chatterOperations() {
        return this.chatterOperations;
    }

    @Override
    public QueryOperations queryOperations() {
        return this.queryOperations;
    }

    @Override
    public RecentOperations recentOperations() {
        return this.recentOperations;
    }

    @Override
    public SearchOperations searchOperations() {
        return this.searchOperations;
    }

    @Override
    public SObjectOperations sObjectsOperations() {
        return this.sObjectsOperations;
    }
    
    @Override
    public StandardObjectOperations standardObjectOperations() {
        return this.standardObjectOperations;
    }

    private void initialize() {
        this.apiOperations = new ApiTemplate(this, getRestTemplate());
        this.chatterOperations = new ChatterTemplate(this, getRestTemplate());
        this.queryOperations = new QueryTemplate(this, getRestTemplate());
        this.recentOperations = new RecentTemplate(this, getRestTemplate());
        this.searchOperations = new SearchTemplate(this, getRestTemplate());
        this.sObjectsOperations = new SObjectsTemplate(this, getRestTemplate());
        this.standardObjectOperations = new StandardObjectTemplate(this, getRestTemplate());
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        final MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new SalesforceModule());
        converter.setObjectMapper(this.objectMapper);
        return converter;
    }

    @Override
    protected void configureRestTemplate(final RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new SalesforceErrorHandler());
    }

    @Override
    public <T> List<T> readList(final JsonNode jsonNode, final Class<T> type) {
        try {
            final CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, type);
            return (List<T>)this.objectMapper.readValue(jsonNode.traverse(), listType);
        } catch (final IOException e) {
            throw new UncategorizedApiException(SalesforceConstants.PROVIDER_ID, "Error deserializing data from Salesforce: " + e.getMessage(), e);
        }
    }

    @Override
    public <T> T readObject(final JsonNode jsonNode, final Class<T> type) {
        try {
            return this.objectMapper.readValue(jsonNode.traverse(), type);
        } catch (final IOException e) {
            throw new UncategorizedApiException(SalesforceConstants.PROVIDER_ID, "Error deserializing data from Salesforce: " + e.getMessage(), e);
        }
    }

    @Override
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Override
    public String getInstanceUrl() {
        return this.instanceUrl;
    }
}
