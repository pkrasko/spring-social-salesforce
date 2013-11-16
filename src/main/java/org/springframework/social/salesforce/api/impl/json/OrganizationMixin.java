package org.springframework.social.salesforce.api.impl.json;

import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * Mixin for {@link org.springframework.social.salesforce.api.Organization}.
 */
public final class OrganizationMixin {

    @JsonProperty("Id")
    String id;
    @JsonProperty("CreatedDate")
    Date createdAt;
    @JsonProperty("LastModifiedDate")
    Date lastModifiedAt;

    @JsonProperty("Name")
    String name;
    @JsonProperty("OrganizationType")
    @JsonDeserialize(using = SalesforceOrgTypeDeserializer.class)
    String organizationType;

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

    @JsonProperty("PrimaryContact")
    String primaryContact;
    @JsonProperty("Phone")
    String phone;
    @JsonProperty("Fax")
    String fax;
    @JsonProperty("LanguageLocaleKey")
    Locale locale;



    private OrganizationMixin() {

    }
}
