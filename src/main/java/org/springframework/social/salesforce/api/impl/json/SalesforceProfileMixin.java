package org.springframework.social.salesforce.api.impl.json;

import org.springframework.social.salesforce.api.Photo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.SalesforceProfile}.
 * 
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesforceProfileMixin {

    @JsonProperty("photo")
    Photo photo;

    @JsonCreator
    SalesforceProfileMixin(
            @JsonProperty("id") final String id,
            @JsonProperty("firstName") final String firstName,
            @JsonProperty("lastName") final String lastName,
            @JsonProperty("email") final String email) {
    }
}
