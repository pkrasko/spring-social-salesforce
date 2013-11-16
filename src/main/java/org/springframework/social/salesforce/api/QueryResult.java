package org.springframework.social.salesforce.api;

import java.util.List;

/**
 * Defines a query result.
 * 
 * @author Umut Utkan
 */
public class QueryResult {

    private int totalSize;

    private boolean done;

    private String nextRecordsUrl;

    private List<ResultItem> records;


    public QueryResult(final int totalSize, final boolean done) {
        this.totalSize = totalSize;
        this.done = done;
    }


    public int getTotalSize() {
        return this.totalSize;
    }

    public boolean isDone() {
        return this.done;
    }

    public List<ResultItem> getRecords() {
        return this.records;
    }

    public void setRecords(final List<ResultItem> records) {
        this.records = records;
    }

    public String getNextRecordsUrl() {
        return this.nextRecordsUrl;
    }

    public void setNextRecordsUrl(final String nextRecordsUrl) {
        this.nextRecordsUrl = nextRecordsUrl;
    }

    /**
     * Retrieve the token to pull the next page of results.
     * 
     * @return token
     */
    public String getNextRecordsToken() {
        if (this.nextRecordsUrl != null) {
            return this.nextRecordsUrl.substring(this.nextRecordsUrl.lastIndexOf('/') + 1, this.nextRecordsUrl.length());
        }
        return null;
    }

}
