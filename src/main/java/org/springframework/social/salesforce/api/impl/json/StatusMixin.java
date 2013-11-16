package org.springframework.social.salesforce.api.impl.json;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.Status}.
 * 
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusMixin {

    @JsonProperty("messageSegments")
    List<Map<String, String>> segments;

    @JsonCreator
    StatusMixin(
            @JsonProperty("text") final String text) {
    }
}
