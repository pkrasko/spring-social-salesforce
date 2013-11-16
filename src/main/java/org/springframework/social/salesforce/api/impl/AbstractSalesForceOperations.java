package org.springframework.social.salesforce.api.impl;

import org.springframework.social.ApiBinding;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.salesforce.SalesforceConstants;

/**
 * Base Salesforce opertion.
 * 
 * @author Umut Utkan
 * @param <T> API Template
 */
public class AbstractSalesForceOperations<T extends ApiBinding> {

    protected final T api;

    public AbstractSalesForceOperations(final T api) {
        this.api = api;
    }

    /**
     * Throws an exception if the API isn't authorized.
     */
    protected void requireAuthorization() {
        if (!this.api.isAuthorized()) {
            throw new MissingAuthorizationException(SalesforceConstants.PROVIDER_ID);
        }
    }
}
