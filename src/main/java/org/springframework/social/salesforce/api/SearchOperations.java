package org.springframework.social.salesforce.api;

import java.util.List;

/**
 * Defines operations to execute SOSL search queries.
 *
 * @author Umut Utkan
 */
public interface SearchOperations {

    /**
     * Query based search.
     * 
     * @param soslQuery The search query
     * @return List of results.
     */
    List<ResultItem> search(String soslQuery);

}
