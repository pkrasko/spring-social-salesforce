package org.springframework.social.salesforce.connect;

import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.social.RejectedAuthorizationException;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.salesforce.SalesforceConstants;
import org.springframework.social.salesforce.SalesforceConstants.AccessTokenRequest;
import org.springframework.social.salesforce.SalesforceConstants.AccessTokenResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Salesforce OAuth2Template implementation.
 * <p/>
 * The reason to extend is to extract non-standard instance_url from Salesforce's oauth token response.
 * 
 * @author Umut Utkan
 */
public class SalesforceOAuth2Template extends OAuth2Template {

    private static final Logger LOG = LoggerFactory.getLogger(SalesforceOAuth2Template.class);
    
    private static final String SIGNING_ALGORITHM = "HmacSHA256";
    private static final String UTF8 = "UTF-8";
    
    private final String accessTokenUrl;
    private final String clientId;
    private final String clientSecret;
    
    private String instanceUrl;
    

    public SalesforceOAuth2Template(final String clientId, final String clientSecret, final String authorizeUrl, final String accessTokenUrl) {
        this(clientId, clientSecret, authorizeUrl, null, accessTokenUrl);
    }

    public SalesforceOAuth2Template(final String clientId, final String clientSecret, final String authorizeUrl, final String authenticateUrl,
            final String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, authenticateUrl, accessTokenUrl);
        this.accessTokenUrl = accessTokenUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        //setUseParametersForClientAuthentication(true);
    }
    
    

    @Override
    protected AccessGrant createAccessGrant(final String accessToken, final String scope, final String refreshToken, final Long expiresIn, final Map<String, Object> response) {
        if (LOG.isDebugEnabled()) {
            final StringBuilder sb = new StringBuilder("Access Token Result [\n");
            for (Entry<String, Object> entry : response.entrySet()) {
                sb.append("    ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            sb.append("]");
            LOG.debug(sb.toString());
        }
        
        validateSignature((String)response.get(AccessTokenResult.PARAM_SIGNATURE),
                (String)response.get(AccessTokenResult.PARAM_ID),
                (String)response.get(AccessTokenResult.PARAM_ISSUED_AT));
        
        this.instanceUrl = (String)response.get(AccessTokenResult.PARAM_INSTANCE_URL);
        
        return new SalesforceAccessGrant(accessToken, scope, refreshToken, response);
    }
    
    /**
     * Handles a username-password OAuth flow.
     * 
     * @param username The username
     * @param password The password
     * @param securityToken The security token
     * @return Access Grant
     */
    public SalesforceAccessGrant exchangeForAccess(final String username, final String password, final String securityToken) {
        final String mergedPassword = password + securityToken;
        
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add(AccessTokenRequest.PARAM_GRANT_TYPE, AccessTokenRequest.GrantTypeValue.password.name());
        params.add(AccessTokenRequest.PARAM_CLIENT_ID, this.clientId);
        params.add(AccessTokenRequest.PARAM_CLIENT_SECRET, this.clientSecret);
        params.add(AccessTokenRequest.PARAM_USERNAME, username);
        params.add(AccessTokenRequest.PARAM_PASSWORD, mergedPassword);
        
        return (SalesforceAccessGrant)postForAccessGrant(this.accessTokenUrl, params);
    }

    public String getInstanceUrl() {
        return this.instanceUrl;
    }
    
    /**
     * Validates the signature included in this message by reconstructing the signature with the client secret.
     */
    private void validateSignature(final String signature, final String id, final String issuedAt) {
        final String data = id + issuedAt;
        final String mac = hmacSHA256(data, this.clientSecret);

        if (mac == null || !mac.equals(signature)) {
            LOG.error("Invalid signature");
            throw new RejectedAuthorizationException(SalesforceConstants.PROVIDER_ID, "Invalid signature");
        }
    }

    private String hmacSHA256(final String data, final String key) {
        try {
            final SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(UTF8), SIGNING_ALGORITHM);
            final Mac mac = Mac.getInstance(SIGNING_ALGORITHM);
            mac.init(secretKey);
            final byte[] hmacData = mac.doFinal(data.getBytes(UTF8));
            return new String(Base64.encode(hmacData), UTF8);
        } catch (final Exception ex) {
            LOG.error("Error while creating HmacSHA256 signature", ex);
            throw new IllegalStateException("Unable to verify OAuth signature", ex);
        }
    }

}
