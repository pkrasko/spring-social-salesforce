package org.springframework.social.salesforce.api;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Defines operations for interacting with the sObjects API.
 *
 * @author Umut Utkan
 */
public interface SObjectOperations {

    /**
     * List all the SObjects.
     * 
     * @return SObjects
     */
    List<Map> getSObjects();

    /**
     * Fetch the summary for a specific SObject.
     * 
     * @param name The SObject name
     * @return summary
     */
    SObjectSummary getSObject(String name);

    /**
     * Fetch the detail for a specific SObject.
     * 
     * @param name The SObject name
     * @return detail
     */
    SObjectDetail describeSObject(String name);

    /**
     * Fetch a specific SObject row based on the name, identifier, and return fields.
     * 
     * @param name The SObject name
     * @param id The SOBject row identifier
     * @param fields The SObject fields to return
     * @return Map
     */
    Map getRow(String name, String id, String... fields);

    /**
     * Fetch a blob of data from Salesforce.
     * 
     * @param name The SObject name
     * @param id The row identifier
     * @param field The blob field name
     * @return inputstream
     */
    InputStream getBlob(String name, String id, String field);

    /**
     * Create a new row for an SObject.
     * 
     * @param name The SObject name
     * @param fields A map containing the field names and values
     * @return SObject
     */
    Map<?, ?> create(String name, Map<String, String> fields);
    
    /**
     * Update an existing row for an SObject.
     * 
     * @param name The SObject name
     * @param id The ID for the row being modified.
     * @param fields A map containing the field names and values
     */
    void update(String name, String id,  Map<String, String> fields);

}
