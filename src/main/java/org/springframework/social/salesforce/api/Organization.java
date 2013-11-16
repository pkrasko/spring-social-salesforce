package org.springframework.social.salesforce.api;

import java.util.Date;
import java.util.Locale;

/**
 * Salesforce Organization object.
 */
public class Organization extends AbstractSalesforceObject {

    private String id;
    private Date createdAt;
    private Date lastModifiedAt;

    private String name;
    private SalesforceOrgType organizationType;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    private String primaryContact;
    private String phone;
    private String fax;
    private Locale locale;

    public Organization() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public void setLastModifiedAt(final Date lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public SalesforceOrgType getOrganizationType() {
        return this.organizationType;
    }

    public void setOrganizationType(final SalesforceOrgType organizationType) {
        this.organizationType = organizationType;
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

    public String getPrimaryContact() {
        return this.primaryContact;
    }

    public void setPrimaryContact(final String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(final String fax) {
        this.fax = fax;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(final Locale locale) {
        this.locale = locale;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Organization [\n    id=");
        builder.append(this.id);
        builder.append("\n    createdAt=");
        builder.append(this.createdAt);
        builder.append("\n    lastModifiedAt=");
        builder.append(this.lastModifiedAt);
        builder.append("\n    name=");
        builder.append(this.name);
        builder.append("\n    organizationType=");
        builder.append(this.organizationType);
        builder.append("\n    street=");
        builder.append(this.street);
        builder.append("\n    city=");
        builder.append(this.city);
        builder.append("\n    state=");
        builder.append(this.state);
        builder.append("\n    postalCode=");
        builder.append(this.postalCode);
        builder.append("\n    country=");
        builder.append(this.country);
        builder.append("\n    primaryContact=");
        builder.append(this.primaryContact);
        builder.append("\n    phone=");
        builder.append(this.phone);
        builder.append("\n    fax=");
        builder.append(this.fax);
        builder.append("\n    locale=");
        builder.append(this.locale);
        builder.append("\n]");
        return builder.toString();
    }

}
