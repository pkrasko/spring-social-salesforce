package org.springframework.social.salesforce.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.social.salesforce.api.Salesforce;

/**
 * Simple caching wrapper for SalesforceFactory.
 * 
 * @author Umut Utkan
 */
public class SimpleCachingSalesforceFactory implements SalesforceFactory {

    private SalesforceFactory delegate;

    private final Map<String, Salesforce> cache = new HashMap<String, Salesforce>();

    public SimpleCachingSalesforceFactory(final SalesforceFactory delegate) {
        this.delegate = delegate;
    }

    @Override
    public Salesforce create(final String username, final String password, final String securityToken) {
        synchronized (this.cache) {
            final Salesforce template = this.cache.get(username);
            if (template == null) {
                this.cache.put(username, this.delegate.create(username, password, securityToken));
            }
            return this.cache.get(username);
        }
    }

}
