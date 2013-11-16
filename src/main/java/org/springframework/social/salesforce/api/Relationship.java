package org.springframework.social.salesforce.api;

/**
 * Defines a relationship in Salesforce.
 * 
 * @author Umut Utkan
 */
public class Relationship {

    private String field;

    private boolean deprecatedAndHidden;

    private String relationshipName;

    private boolean cascadeDelete;

    private boolean restrictedDelete;

    private String childSObject;

    public Relationship(final String field, final String relationshipName, final String childObject) {
        this.field = field;
        this.relationshipName = relationshipName;
        this.childSObject = childObject;
    }

    public String getField() {
        return this.field;
    }

    public String getRelationshipName() {
        return this.relationshipName;
    }

    public String getChildSObject() {
        return this.childSObject;
    }

    public boolean isDeprecatedAndHidden() {
        return this.deprecatedAndHidden;
    }

    public void setDeprecatedAndHidden(final boolean deprecatedAndHidden) {
        this.deprecatedAndHidden = deprecatedAndHidden;
    }

    public boolean isCascadeDelete() {
        return this.cascadeDelete;
    }

    public void setCascadeDelete(final boolean cascadeDelete) {
        this.cascadeDelete = cascadeDelete;
    }

    public boolean isRestrictedDelete() {
        return this.restrictedDelete;
    }

    public void setRestrictedDelete(final boolean restrictedDelete) {
        this.restrictedDelete = restrictedDelete;
    }

}
