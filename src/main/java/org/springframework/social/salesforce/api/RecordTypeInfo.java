package org.springframework.social.salesforce.api;

/**
 * Defines a record type.
 * 
 * @author Umut Utkan
 */
public class RecordTypeInfo {

    private String name;

    private boolean available;

    private String recordTypeId;

    private boolean defaultRecordTypeMapping;

    public RecordTypeInfo(final String name, final boolean available, final String recordTypeId, final boolean defaultRecordTypeMapping) {
        this.name = name;
        this.available = available;
        this.recordTypeId = recordTypeId;
        this.defaultRecordTypeMapping = defaultRecordTypeMapping;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public String getRecordTypeId() {
        return this.recordTypeId;
    }

    public boolean isDefaultRecordTypeMapping() {
        return this.defaultRecordTypeMapping;
    }

}
