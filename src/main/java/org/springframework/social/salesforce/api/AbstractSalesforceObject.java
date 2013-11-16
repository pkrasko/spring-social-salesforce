package org.springframework.social.salesforce.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Common fields.
 */
abstract class AbstractSalesforceObject implements Serializable {

    /** Default SN. */
    private static final long serialVersionUID = 1L;

    private static final String INVALID_TOKEN = "INVALID_SESSION_ID";

    @JsonProperty("errorCode")
    private String errorCode;
    @JsonProperty("message")
    private String message;

    private Map<String, Object> extraProperties = new HashMap<String, Object>();

    public AbstractSalesforceObject() {

    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Unknown properties are set here.
     * 
     * @param key Key
     * @param value Value
     */
    @JsonAnySetter
    public void addExtraProperty(final String key, final Object value) {
        this.extraProperties.put(key, value);
    }

    public Map<String, Object> getExtraProperties() {
        return this.extraProperties;
    }

    /**
     * Determine if there are errors.
     * 
     * @return true if errors are present.
     */
    public boolean hasErrors() {
        return StringUtils.hasText(this.errorCode);
    }

    /**
     * See if the session/access token expired.
     * 
     * @return true if it's expired.
     */
    public boolean hasTokenExpired() {
        if (this.errorCode != null && this.errorCode.equalsIgnoreCase(INVALID_TOKEN)) {
            return true;
        }
        return false;
    }

}
