package org.springframework.social.salesforce.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.Relationship}.
 * 
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RelationshipMixin {

    @JsonProperty("deprecatedAndHidden")
    boolean deprecatedAndHidden;

    @JsonProperty("cascadeDelete")
    boolean cascadeDelete;

    @JsonProperty("restrictedDelete")
    boolean restrictedDelete;

    @JsonCreator
    RelationshipMixin(
            @JsonProperty("field") final String field,
            @JsonProperty("relationshipName") final String relationshipName,
            @JsonProperty("childObject") final String childObject) {
    }
}
