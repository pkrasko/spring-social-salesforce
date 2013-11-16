package org.springframework.social.connect.support;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * If the access token has expired, this will first call a refresh on the connection before
 * returning the API binding.
 * 
 * @author Umut Utkan
 * @param <A> ApiBinding type
 */
public class RefreshingOAuth2Connection<A> extends OAuth2Connection<A> {

    public RefreshingOAuth2Connection(final String providerId, final String providerUserId, final String accessToken, final String refreshToken,
            final Long expireTime, final OAuth2ServiceProvider<A> aoAuth2ServiceProvider, final ApiAdapter<A> aApiAdapter) {
        super(providerId, providerUserId, accessToken, refreshToken, expireTime, aoAuth2ServiceProvider, aApiAdapter);
    }

    public RefreshingOAuth2Connection(final ConnectionData data, final OAuth2ServiceProvider<A> aoAuth2ServiceProvider, final ApiAdapter<A> aApiAdapter) {
        super(data, aoAuth2ServiceProvider, aApiAdapter);
    }

    @Override
    public A getApi() {
        if (hasExpired()) {
            refresh();
        }
        return super.getApi();
    }

}
