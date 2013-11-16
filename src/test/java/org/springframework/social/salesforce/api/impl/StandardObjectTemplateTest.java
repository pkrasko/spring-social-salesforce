/*
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.social.salesforce.SalesforceConstants;
import org.springframework.social.salesforce.SalesforceConstants.Endpoints.StandardObjects;
import org.springframework.social.salesforce.api.Identity;
import org.springframework.social.salesforce.api.Organization;
import org.springframework.social.salesforce.api.SalesforceOrgType;
import org.springframework.social.salesforce.api.User;
import org.springframework.social.salesforce.connect.SalesforceAccessGrant;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

/**
 * Test cases for the {@link StandardObjectTemplate}.
 */
public class StandardObjectTemplateTest extends AbstractSalesforceTest {

    @Test
    public void getOrganization() {
        final String id = "00D700000008MdoEAE";

        final String name = "MobileIron, Inc";
        final SalesforceOrgType organizationType = SalesforceOrgType.DEVELOPER_EDITION;

        final String street = "415 E Middlefield Rd";
        final String city = "Mountain View";
        final String state = "CA";
        final String postalCode = "94110";
        final String country = "US";

        final String primaryContact = "Phil Krasko";

        this.mockServer.expect(requestTo(VERSION_URL + "/sobjects/" + StandardObjects.Organization.name() + "/" + id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("organization.json"), this.responseHeaders));
        final Organization org = this.salesforce.standardObjectOperations().getOrganization(id);
        assertThat(org, notNullValue());
        assertThat(org.getLocale(), notNullValue());
        assertThat(org.getLastModifiedAt(), notNullValue());
        assertThat(org.getId(), equalTo(id));
        assertThat(org.getName(), equalTo(name));
        assertThat(org.getOrganizationType(), equalTo(organizationType));
        assertThat(org.getStreet(), equalTo(street));
        assertThat(org.getCity(), equalTo(city));
        assertThat(org.getState(), equalTo(state));
        assertThat(org.getPostalCode(), equalTo(postalCode));
        assertThat(org.getCountry(), equalTo(country));
        assertThat(org.getPrimaryContact(), equalTo(primaryContact));
    }

    @Test
    public void getUser() {

        final String id = "0057000000125c8AAA";
        final String username = "pkrasko@gmail.com";

        final String name = "Phil Krasko";
        final String firstName = "Phil";
        final String lastName = "Krasko";
        final String displayName = "pkrasko";
        final String alias = "pkrasko";
        final String email = "pkrasko@gmail.com";
        final String title = "Nerd";

        final String street = "415 E Middlefield Rd";
        final String city = "Mountain View";
        final String state = "CA";
        final String postalCode = "94110";
        final String country = "US";

        final String profileId = "00e70000000pFfZAAU";
        final String userType = "Standard";

        this.mockServer.expect(requestTo(VERSION_URL + "/sobjects/" + StandardObjects.User.name() + "/" + id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("user.json"), this.responseHeaders));
        final User user = this.salesforce.standardObjectOperations().getUser(id);

        assertThat(user, notNullValue());
        assertThat(user.getLocale(), notNullValue());

        assertThat(user.getId(), equalTo(id));
        assertThat(user.getUsername(), equalTo(username));
        assertThat(user.getName(), equalTo(name));
        assertThat(user.getFirstName(), equalTo(firstName));
        assertThat(user.getLastName(), equalTo(lastName));
        assertThat(user.getAlias(), equalTo(alias));
        assertThat(user.getDisplayName(), equalTo(displayName));
        assertThat(user.getEmail(), equalTo(email));
        assertThat(user.getTitle(), equalTo(title));
        assertThat(user.getStreet(), equalTo(street));
        assertThat(user.getCity(), equalTo(city));
        assertThat(user.getState(), equalTo(state));
        assertThat(user.getPostalCode(), equalTo(postalCode));
        assertThat(user.getCountry(), equalTo(country));
        assertThat(user.getProfileId(), equalTo(profileId));
        assertThat(user.getUserType(), equalTo(userType));
    }

    @Test
    public void getIdentity() {

        final String id = "http://na1.salesforce.com/id/00Dx0000001T0zk/005x0000001S2b9";
        final Map<String, Object> param = new HashMap<String, Object>();
        param.put(SalesforceConstants.AccessTokenResult.PARAM_ID, id);
        param.put(SalesforceConstants.AccessTokenResult.PARAM_INSTANCE_URL, "http://na1.salesforce.com");
        param.put(SalesforceConstants.AccessTokenResult.PARAM_ISSUED_AT, System.currentTimeMillis() + "");
        param.put(SalesforceConstants.AccessTokenResult.PARAM_SIGNATURE, "abcdef");

        final SalesforceAccessGrant accessGrant = new SalesforceAccessGrant("access-token", "scope-api", "refresh-token", param);

        this.mockServer.expect(requestTo(id))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("identity.json"), this.responseHeaders));

        final Identity identity = this.salesforce.standardObjectOperations().getIdentity(accessGrant);

        assertThat(identity, notNullValue());
        assertThat(identity.getApiProfile(), notNullValue());
        assertThat(identity.getPhotos(), notNullValue());
        assertThat(identity.getStatus(), notNullValue());
        assertThat(identity.getLocale(), notNullValue());
    }
}
