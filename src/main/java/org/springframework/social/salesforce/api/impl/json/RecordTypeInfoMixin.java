package org.springframework.social.salesforce.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.RecordTypeInfo}.
 *
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordTypeInfoMixin {

    @JsonCreator
    RecordTypeInfoMixin(
            @JsonProperty("name") final String name,
            @JsonProperty("available") final boolean available,
            @JsonProperty("recordTypeId") final String recordTypeId,
            @JsonProperty("defaultRecordTypeMapping") final boolean defaultRecordTypeMapping) {
    }

}
