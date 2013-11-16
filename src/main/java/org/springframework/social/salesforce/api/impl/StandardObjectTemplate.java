package org.springframework.social.salesforce.api.impl;

import org.springframework.social.salesforce.SalesforceConstants.Endpoints;
import org.springframework.social.salesforce.SalesforceConstants.Endpoints.StandardObjects;
import org.springframework.social.salesforce.api.Identity;
import org.springframework.social.salesforce.api.Organization;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.api.StandardObjectOperations;
import org.springframework.social.salesforce.api.User;
import org.springframework.social.salesforce.connect.SalesforceAccessGrant;
import org.springframework.web.client.RestTemplate;


/**
 * Default implementation for the {@link StandardObjectOperations}.
 */
public class StandardObjectTemplate extends AbstractSalesForceOperations<Salesforce> implements StandardObjectOperations {

    private final RestTemplate restTemplate;
    
    public StandardObjectTemplate(final Salesforce api, final RestTemplate restTemplate) {
        super(api);
        this.restTemplate = restTemplate;
    }
    
    /**
     * {@inheritDoc}
     * @see org.springframework.social.salesforce.api.StandardObjectOperations#getOrganization(java.lang.String)
     */
    @Override
    public Organization getOrganization(final String orgId) {
        requireAuthorization();
        return this.restTemplate.getForObject(this.api.getBaseUrl() + Endpoints.SObjects.BY_ROW, Organization.class, StandardObjects.Organization.name(), orgId);
    }

    /**
     * {@inheritDoc}
     * @see org.springframework.social.salesforce.api.StandardObjectOperations#getUser(java.lang.String)
     */
    @Override
    public User getUser(final String userId) {
        requireAuthorization();
        return this.restTemplate.getForObject(this.api.getBaseUrl() + Endpoints.SObjects.BY_ROW, User.class, StandardObjects.User.name(), userId);
    }

    /**
     * {@inheritDoc}
     * @see org.springframework.social.salesforce.api.StandardObjectOperations#getIdentity(org.springframework.social.salesforce.connect.SalesforceAccessGrant)
     */
    @Override
    public Identity getIdentity(final SalesforceAccessGrant accessGrant) {
        requireAuthorization();
        return this.restTemplate.getForObject(accessGrant.getId(), Identity.class);
    }

}
