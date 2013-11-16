package org.springframework.social.salesforce.api;

import java.util.List;
import java.util.Map;

/**
 * Defines operations for getting info on the API.
 * 
 * @author Umut Utkan
 */
public interface ApiOperations {

    /**
     * Retrieve the API versions made available by Salesforce.
     * 
     * @return List of available API version.
     */
    List<ApiVersion> getVersions();

    /**
     * Retrieve a Map containing the service names to endpoints
     * for the available RESTful services.
     * 
     * @param version The version of the API you wish to pull services for.
     * @return Map
     */
    Map<String, String> getServices(final String version);

}
