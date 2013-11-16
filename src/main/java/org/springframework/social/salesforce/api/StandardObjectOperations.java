/*
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api;

import org.springframework.social.salesforce.connect.SalesforceAccessGrant;


/**
 * Strongly typed operations with well known Saleforce data types.
 */
public interface StandardObjectOperations {

    /**
     * Fetch the Salesforce Organization by its identifier.
     * 
     * @param orgId The organization identifier
     * @return Organization
     */
    Organization getOrganization(final String orgId);
    
    /**
     * Fetch the Salesforce User by their identifier.
     * 
     * @param userId The user identifier
     * @return User
     */
    User getUser(final String userId);
    
    /**
     * Fetch the identity tied to an {@link SalesforceAccessGrant}.
     * 
     * @param accessGrant The salesforce access grant
     * @return Identity
     */
    Identity getIdentity(final SalesforceAccessGrant accessGrant);
}
