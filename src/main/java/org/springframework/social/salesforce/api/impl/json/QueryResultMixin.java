package org.springframework.social.salesforce.api.impl.json;

import java.util.List;

import org.springframework.social.salesforce.api.ResultItem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mixin for {@link org.springframework.social.salesforce.api.QueryResult}.
 * 
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResultMixin {

    @JsonProperty("nextRecordsUrl")
    String nextRecordsUrl;

    @JsonProperty("records")
    List<ResultItem> records;

    @JsonCreator
    QueryResultMixin(
            @JsonProperty("totalSize") final int totalSize,
            @JsonProperty("done") final boolean done) {
    }

}
