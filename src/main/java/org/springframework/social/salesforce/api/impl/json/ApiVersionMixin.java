package org.springframework.social.salesforce.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.ApiVersion}.
 *
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiVersionMixin {

    @JsonCreator
    ApiVersionMixin(
            @JsonProperty("version") final String version,
            @JsonProperty("label") final String label,
            @JsonProperty("url") final String url) {
    }

}
