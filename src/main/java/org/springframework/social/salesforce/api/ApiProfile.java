package org.springframework.social.salesforce.api;


/**
 * Stores the URLs to the APIs.
 */
public final class ApiProfile extends AbstractSalesforceObject {

    /** Default SN. */
    private static final long serialVersionUID = 1L;

    private String enterprise;
    private String metadata;
    private String partner;
    private String rest;
    private String sObjects;
    private String search;
    private String query;
    private String profile;

    public ApiProfile() {

    }

    public String getEnterprise() {
        return this.enterprise;
    }

    public void setEnterprise(final String enterprise) {
        this.enterprise = enterprise;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public void setMetadata(final String metadata) {
        this.metadata = metadata;
    }

    public String getPartner() {
        return this.partner;
    }

    public void setPartner(final String partner) {
        this.partner = partner;
    }

    public String getRest() {
        return this.rest;
    }

    public void setRest(final String rest) {
        this.rest = rest;
    }

    public String getSObjects() {
        return this.sObjects;
    }

    public void setSObjects(final String sObjects) {
        this.sObjects = sObjects;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(final String search) {
        this.search = search;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(final String query) {
        this.query = query;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(final String profile) {
        this.profile = profile;
    }

}
