/*
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api;

import java.util.Date;
import java.util.Locale;

/**
 * Salesforce User object.
 */
public class User extends AbstractSalesforceObject {

    private String id;
    private String accountId;
    private String federationId;
    private String username;
    private Date modifiedAt;

    private String name;
    private String firstName;
    private String lastName;
    private String displayName;
    private String alias;
    private String email;
    private String title;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    private String mobilePhone;
    private String phone;
    private Locale locale;

    private String profileId;
    private String userRoleId;
    private String userType;

    public User() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public String getFederationId() {
        return this.federationId;
    }

    public void setFederationId(final String federationId) {
        this.federationId = federationId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(final Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(final Locale locale) {
        this.locale = locale;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public void setProfileId(final String profileId) {
        this.profileId = profileId;
    }

    public String getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(final String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

}
