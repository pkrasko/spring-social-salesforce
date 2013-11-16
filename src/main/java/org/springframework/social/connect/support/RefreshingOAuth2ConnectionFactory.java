package org.springframework.social.connect.support;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * Connection factory.
 * 
 * @author Umut Utkan
 * 
 * @param <S> Service provider
 */
public class RefreshingOAuth2ConnectionFactory<S> extends OAuth2ConnectionFactory<S> {

    public RefreshingOAuth2ConnectionFactory(final String providerId, final OAuth2ServiceProvider<S> soAuth2ServiceProvider, final ApiAdapter<S> sApiAdapter) {
        super(providerId, soAuth2ServiceProvider, sApiAdapter);
    }

    @Override
    public Connection<S> createConnection(final AccessGrant accessGrant) {
        return new RefreshingOAuth2Connection<S>(getProviderId(), extractProviderUserId(accessGrant), accessGrant.getAccessToken(),
                accessGrant.getRefreshToken(), accessGrant.getExpireTime(), (OAuth2ServiceProvider<S>)getServiceProvider(), getApiAdapter());
    }

    @Override
    public Connection<S> createConnection(final ConnectionData data) {
        return new RefreshingOAuth2Connection<S>(data, (OAuth2ServiceProvider<S>)getServiceProvider(), getApiAdapter());
    }

}
