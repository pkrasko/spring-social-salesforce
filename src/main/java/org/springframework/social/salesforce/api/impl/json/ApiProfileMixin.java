package org.springframework.social.salesforce.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Mixin for {@link org.springframework.social.salesforce.api.ApiProfile}.
 */
public final class ApiProfileMixin {

    @JsonProperty("enterprise")
    String enterprise;

    @JsonProperty("metadata")
    String metadata;

    @JsonProperty("partner")
    String partner;

    @JsonProperty("rest")
    String rest;

    @JsonProperty("sobjects")
    String sObjects;

    @JsonProperty("search")
    String search;

    @JsonProperty("query")
    String query;

    @JsonProperty("profile")
    String profile;
    
    private ApiProfileMixin() {
        
    }
}
