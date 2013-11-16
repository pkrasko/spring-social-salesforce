/*
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api.impl.json;

import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Mixin for {@link org.springframework.social.salesforce.api.User}.
 */
public final class UserMixin {

    @JsonProperty("Id")
    String id;
    @JsonProperty("AccountId")
    String accountId;
    @JsonProperty("FederationIdentifier")
    String federationId;
    @JsonProperty("Username")
    String username;
    @JsonProperty("LastModifiedDate")
    Date modifiedAt;

    @JsonProperty("Name")
    String name;
    @JsonProperty("FirstName")
    String firstName;
    @JsonProperty("LastName")
    String lastName;
    @JsonProperty("CommunityNickname")
    String displayName;
    @JsonProperty("Alias")
    String alias;
    @JsonProperty("Email")
    String email;
    @JsonProperty("Title")
    String title;

    @JsonProperty("Street")
    String street;
    @JsonProperty("City")
    String city;
    @JsonProperty("State")
    String state;
    @JsonProperty("PostalCode")
    String postalCode;
    @JsonProperty("Country")
    String country;

    @JsonProperty("MobilePhone")
    String mobilePhone;
    @JsonProperty("Phone")
    String phone;
    @JsonProperty("LocaleSidKey")
    Locale locale;

    @JsonProperty("ProfileId")
    String profileId;
    @JsonProperty("UserRoleId")
    String userRoleId;
    @JsonProperty("UserType")
    String userType;
    
    private UserMixin() {
        
    }
}
