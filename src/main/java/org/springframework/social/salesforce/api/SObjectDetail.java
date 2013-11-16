package org.springframework.social.salesforce.api;

import java.util.List;

/**
 * Describes the detail for an SObject.
 * 
 * @author Umut Utkan
 */
public class SObjectDetail extends SObjectSummary {

    private List<Field> fields;
    private List<Relationship> childRelationships;
    private boolean listviewable;
    private boolean lookupLayoutable;
    private List<RecordTypeInfo> recordTypeInfos;
    private boolean searchLayoutable;

    public SObjectDetail() {

    }

    public List<Field> getFields() {
        return this.fields;
    }

    public void setFields(final List<Field> fields) {
        this.fields = fields;
    }

    public List<Relationship> getChildRelationships() {
        return this.childRelationships;
    }

    public void setChildRelationships(final List<Relationship> childRelationships) {
        this.childRelationships = childRelationships;
    }

    public boolean isListviewable() {
        return this.listviewable;
    }

    public void setListviewable(final boolean listviewable) {
        this.listviewable = listviewable;
    }

    public boolean isLookupLayoutable() {
        return this.lookupLayoutable;
    }

    public void setLookupLayoutable(final boolean lookupLayoutable) {
        this.lookupLayoutable = lookupLayoutable;
    }

    public List<RecordTypeInfo> getRecordTypeInfos() {
        return this.recordTypeInfos;
    }

    public void setRecordTypeInfos(final List<RecordTypeInfo> recordTypeInfos) {
        this.recordTypeInfos = recordTypeInfos;
    }

    public boolean isSearchLayoutable() {
        return this.searchLayoutable;
    }

    public void setSearchLayoutable(final boolean searchLayoutable) {
        this.searchLayoutable = searchLayoutable;
    }

}
