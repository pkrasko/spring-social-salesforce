package org.springframework.social.salesforce.connect;

import java.util.Map;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.salesforce.SalesforceConstants;

/**
 * Access grant storing additional custom Salesforce fields.
 */
public class SalesforceAccessGrant extends AccessGrant {

    private static final long serialVersionUID = 1L;
    
    private final String instanceUrl;
    private final String id;
    private final String signature;
    private final String issuedAt;

    /**
     * Used by the OAuth template.
     * 
     * @param accessToken The access token
     * @param scope The scope
     * @param refreshToken The refresh token
     * @param response Map containing the key value pairs of data returned in the access token response.
     */
    public SalesforceAccessGrant(final String accessToken, final String scope, final String refreshToken, final Map<String, Object> response) {
        super(accessToken, scope, refreshToken, null);
        this.instanceUrl = (String)response.get(SalesforceConstants.AccessTokenResult.PARAM_INSTANCE_URL);
        this.id = (String)response.get(SalesforceConstants.AccessTokenResult.PARAM_ID);
        this.signature = (String)response.get(SalesforceConstants.AccessTokenResult.PARAM_SIGNATURE);
        this.issuedAt = (String)response.get(SalesforceConstants.AccessTokenResult.PARAM_ISSUED_AT);
    }

    /**
     * Used to reconstruct access tokens.
     * 
     * @param accessToken The access token
     * @param scope The scope
     * @param refreshToken The refresh token
     * @param instanceUrl The instance url
     * @param id A URL to the user's identity
     */
    public SalesforceAccessGrant(final String accessToken, final String scope, final String refreshToken, final String instanceUrl, final String id) {
        super(accessToken, scope, refreshToken, null);
        this.instanceUrl = instanceUrl;
        this.id = id;
        this.signature = null;
        this.issuedAt = null;
    }

    public String getInstanceUrl() {
        return this.instanceUrl;
    }

    /**
     * Return a URL to retrieve the identity of the user.
     * 
     * @return URL
     */
    public String getId() {
        return this.id;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getIssuedAt() {
        return this.issuedAt;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("SalesforceAccessGrant [\n    instanceUrl=");
        builder.append(this.instanceUrl);
        builder.append("\n    id=");
        builder.append(this.id);
        builder.append("\n    signature=");
        builder.append(this.signature);
        builder.append("\n    issuedAt=");
        builder.append(this.issuedAt);
        builder.append("\n    scope=");
        builder.append(this.getScope());
        builder.append("\n    accessToken=");
        builder.append(getAccessToken() == null ? "NULL" : "PROTECTED");
        builder.append("\n    refreshToken=");
        builder.append(getRefreshToken() == null ? "NULL" : "PROTECTED");
        builder.append("\n]");
        return builder.toString();
    }

    
}
