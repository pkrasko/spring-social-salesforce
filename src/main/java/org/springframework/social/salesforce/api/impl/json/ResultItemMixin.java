package org.springframework.social.salesforce.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.ResultItem}.
 *
 * @author Umut Utkan
 */
@JsonDeserialize(using = ResultItemDeserializer.class)
public final class ResultItemMixin {
    
    private ResultItemMixin() {
        
    }
}
