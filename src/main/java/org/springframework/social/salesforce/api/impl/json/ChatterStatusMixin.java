package org.springframework.social.salesforce.api.impl.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Mixin for {@link org.springframework.social.salesforce.api.ChatterStatus}.
 */
public final class ChatterStatusMixin {

    @JsonProperty("created_date")
    Date createdDate;
    
    @JsonProperty("body")
    String body;
    
    private ChatterStatusMixin() {
        
    }
}
