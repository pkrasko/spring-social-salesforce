package org.springframework.social.salesforce.api;

/**
 * Describes a picklist entry within Salesforce.
 * 
 * @author Umut Utkan
 */
public class PickListEntry {

    private String value;

    private boolean active;

    private String label;

    private boolean defaultValue;

    //TODO: find how to deserialize.
    //private String validFor;


    public PickListEntry(final String value, final String label, final boolean active, final boolean defaultValue) {
        this.value = value;
        this.active = active;
        this.label = label;
        this.defaultValue = defaultValue;
    }


    public String getValue() {
        return this.value;
    }

    public boolean isActive() {
        return this.active;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isDefaultValue() {
        return this.defaultValue;
    }

}
