package org.springframework.social.salesforce.api;

import org.springframework.social.ApiException;
import org.springframework.social.salesforce.SalesforceConstants;

/**
 * Thrown when the client makes a bad request to Salesforce.
 * 
 * @author Umut Utkan
 */
public class InvalidIDException extends ApiException {

    private static final long serialVersionUID = 1L;

    public InvalidIDException(final String message) {
        super(SalesforceConstants.PROVIDER_ID, message);
    }

}
