package org.springframework.social.salesforce.api;

/**
 * Defines operations for executing SOQL queries.
 * 
 * @author Umut Utkan
 */
public interface QueryOperations {

    /**
     * Execute a query against Salesforce.
     * 
     * @param query The SOQL query string.
     * @return Query result
     */
    QueryResult query(String query);

    /**
     * Fetch the next page of results.
     * 
     * @param urlOrToken Cursor.
     * @return Query result
     */
    QueryResult nextPage(String urlOrToken);

}
