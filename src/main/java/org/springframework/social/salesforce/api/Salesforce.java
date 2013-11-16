package org.springframework.social.salesforce.api;

import java.util.List;

import org.springframework.social.ApiBinding;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Specifies operations performed on Salesforce.
 *
 * @author Umut Utkan
 */
public interface Salesforce extends ApiBinding {

    /**
     * API Operations.
     * 
     * @return API operations
     */
    ApiOperations apiOperations();

    /**
     * Chatter Operations.
     * 
     * @return Chatter operations
     */
    ChatterOperations chatterOperations();

    /**
     * Query Operations.
     * 
     * @return Query operations
     */
    QueryOperations queryOperations();

    /**
     * Recent Operations.
     * 
     * @return Recent operations
     */
    RecentOperations recentOperations();

    /**
     * Search Operations.
     * 
     * @return Search operations
     */
    SearchOperations searchOperations();

    /**
     * SObject Operations.
     * 
     * @return SObject operations
     */
    SObjectOperations sObjectsOperations();
    
    /**
     * Standard object operations.
     * 
     * @return Standard object operations.
     */
    StandardObjectOperations standardObjectOperations();

    /**
     * Unmarshall json nodes to the specified type.
     * 
     * @param jsonNode The json node
     * @param type The object type.
     * @param <T> The object type
     * @return List of objects
     */
    <T> List<T> readList(JsonNode jsonNode, Class<T> type);

    /**
     * Unmarshall a json node to the specified type.
     * 
     * @param jsonNode the json node
     * @param type The object type.
     * @param <T> The object type
     * @return Object
     */
    <T> T readObject(JsonNode jsonNode, Class<T> type);

    /**
     * Retrieve the base url - the instance url plus 
     * the base path for the API level.
     * 
     * @return Base url
     */
    String getBaseUrl();

    /**
     * Retrieve the Salesforce instance url for the connection.
     * 
     * @return Salesforce instance/cluster url.
     */
    String getInstanceUrl();

}
