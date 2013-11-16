package org.springframework.social.salesforce.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.PickListEntry}.
 *
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PickListEntryMixin {

    @JsonCreator
    PickListEntryMixin(
            @JsonProperty("value") final String value,
            @JsonProperty("label") final String label,
            @JsonProperty("active") final boolean active,
            @JsonProperty("defaultValue") final boolean defaultValue) {
    }

}
