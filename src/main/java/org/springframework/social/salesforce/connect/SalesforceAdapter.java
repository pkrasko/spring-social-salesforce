package org.springframework.social.salesforce.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.social.salesforce.api.SalesforceProfile;

/**
 * Salesforce ApiAdapter implementation.
 * 
 * @author Umut Utkan
 */
public class SalesforceAdapter implements ApiAdapter<Salesforce> {

    public SalesforceAdapter() {
        super();
    }
    
    @Override
    public boolean test(final Salesforce salesForce) {
        try {
            salesForce.chatterOperations().getUserProfile();
            return true;
        } catch (final ApiException e) {
            return false;
        }
    }

    @Override
    public void setConnectionValues(final Salesforce salesforce, final ConnectionValues values) {
        final SalesforceProfile profile = salesforce.chatterOperations().getUserProfile();
        values.setProviderUserId(profile.getId());
        values.setDisplayName(profile.getFirstName() + " " + profile.getLastName());
    }

    @Override
    public UserProfile fetchUserProfile(final Salesforce salesforce) {
        final SalesforceProfile profile = salesforce.chatterOperations().getUserProfile();
        return new UserProfileBuilder().setName(profile.getFirstName()).setFirstName(profile.getFirstName())
                .setLastName(profile.getLastName()).setEmail(profile.getEmail())
                .setUsername(profile.getEmail()).build();
    }

    @Override
    public void updateStatus(final Salesforce salesforce, final String message) {
        salesforce.chatterOperations().updateStatus(message);
    }
}
