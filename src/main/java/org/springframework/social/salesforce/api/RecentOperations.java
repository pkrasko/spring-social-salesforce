package org.springframework.social.salesforce.api;

import java.util.List;

/**
 * Defines operations for interacting with Recent API.
 *
 * @author Umut Utkan
 */
public interface RecentOperations {

    /**
     * Fetch the recent activity.
     * 
     * @return List of recent activity
     */
    List<ResultItem> recent();

}
