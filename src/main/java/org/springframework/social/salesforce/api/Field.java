package org.springframework.social.salesforce.api;

import java.util.List;

/**
 * Describes a Field within the Salesforce platform.
 * 
 * @author Umut Utkan
 */
public class Field {

    private int length;

    private String name;

    private String type;

    private String defaultValue;

    private String label;

    private boolean updateable;

    private boolean calculated;

    private boolean filterable;

    private boolean sortable;

    private String controllerName;

    private boolean unique;

    private boolean nillable;

    private int precision;

    private int scale;

    private boolean caseSensitive;

    private int byteLength;

    private boolean nameField;

    private boolean externalId;

    private boolean idLookup;

    private String inlineHelpText;

    private boolean createable;

    private String soapType;

    private boolean autoNumber;

    private boolean namePointing;

    private boolean custom;

    private boolean defaultedOnCreate;

    private boolean deprecatedAndHidden;

    private boolean htmlFormatted;

    private String defaultValueFormula;

    private String calculatedFormula;

    private boolean restrictedPicklist;

    private List<PickListEntry> picklistValues;

    private boolean dependentPicklist;

    private String[] referenceTo;

    private String relationshipName;

    private int relationshipOrder;

    private boolean writeRequiresMasterRead;

    private boolean cascadeDelete;

    private boolean restrictedDelete;

    private int digits;

    private boolean groupable;


    public Field(final String name, final String type, final String label) {
        this.name = name;
        this.type = type;
        this.label = label;
    }


    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getLabel() {
        return this.label;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isUpdateable() {
        return this.updateable;
    }

    public void setUpdateable(final boolean updateable) {
        this.updateable = updateable;
    }

    public boolean isCalculated() {
        return this.calculated;
    }

    public void setCalculated(final boolean calculated) {
        this.calculated = calculated;
    }

    public boolean isFilterable() {
        return this.filterable;
    }

    public void setFilterable(final boolean filterable) {
        this.filterable = filterable;
    }

    public boolean isSortable() {
        return this.sortable;
    }

    public void setSortable(final boolean sortable) {
        this.sortable = sortable;
    }

    public String getControllerName() {
        return this.controllerName;
    }

    public void setControllerName(final String controllerName) {
        this.controllerName = controllerName;
    }

    public boolean isUnique() {
        return this.unique;
    }

    public void setUnique(final boolean unique) {
        this.unique = unique;
    }

    public boolean isNillable() {
        return this.nillable;
    }

    public void setNillable(final boolean nillable) {
        this.nillable = nillable;
    }

    public int getPrecision() {
        return this.precision;
    }

    public void setPrecision(final int precision) {
        this.precision = precision;
    }

    public int getScale() {
        return this.scale;
    }

    public void setScale(final int scale) {
        this.scale = scale;
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public void setCaseSensitive(final boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public int getByteLength() {
        return this.byteLength;
    }

    public void setByteLength(final int byteLength) {
        this.byteLength = byteLength;
    }

    public boolean isNameField() {
        return this.nameField;
    }

    public void setNameField(final boolean nameField) {
        this.nameField = nameField;
    }

    public boolean isExternalId() {
        return this.externalId;
    }

    public void setExternalId(final boolean externalId) {
        this.externalId = externalId;
    }

    public boolean isIdLookup() {
        return this.idLookup;
    }

    public void setIdLookup(final boolean idLookup) {
        this.idLookup = idLookup;
    }

    public String getInlineHelpText() {
        return this.inlineHelpText;
    }

    public void setInlineHelpText(final String inlineHelpText) {
        this.inlineHelpText = inlineHelpText;
    }

    public boolean isCreateable() {
        return this.createable;
    }

    public void setCreateable(final boolean createable) {
        this.createable = createable;
    }

    public String getSoapType() {
        return this.soapType;
    }

    public void setSoapType(final String soapType) {
        this.soapType = soapType;
    }

    public boolean isAutoNumber() {
        return this.autoNumber;
    }

    public void setAutoNumber(final boolean autoNumber) {
        this.autoNumber = autoNumber;
    }

    public boolean isNamePointing() {
        return this.namePointing;
    }

    public void setNamePointing(final boolean namePointing) {
        this.namePointing = namePointing;
    }

    public boolean isCustom() {
        return this.custom;
    }

    public void setCustom(final boolean custom) {
        this.custom = custom;
    }

    public boolean isDefaultedOnCreate() {
        return this.defaultedOnCreate;
    }

    public void setDefaultedOnCreate(final boolean defaultedOnCreate) {
        this.defaultedOnCreate = defaultedOnCreate;
    }

    public boolean isDeprecatedAndHidden() {
        return this.deprecatedAndHidden;
    }

    public void setDeprecatedAndHidden(final boolean deprecatedAndHidden) {
        this.deprecatedAndHidden = deprecatedAndHidden;
    }

    public boolean isHtmlFormatted() {
        return this.htmlFormatted;
    }

    public void setHtmlFormatted(final boolean htmlFormatted) {
        this.htmlFormatted = htmlFormatted;
    }

    public String getDefaultValueFormula() {
        return this.defaultValueFormula;
    }

    public void setDefaultValueFormula(final String defaultValueFormula) {
        this.defaultValueFormula = defaultValueFormula;
    }

    public String getCalculatedFormula() {
        return this.calculatedFormula;
    }

    public void setCalculatedFormula(final String calculatedFormula) {
        this.calculatedFormula = calculatedFormula;
    }

    public boolean isRestrictedPicklist() {
        return this.restrictedPicklist;
    }

    public void setRestrictedPicklist(final boolean restrictedPicklist) {
        this.restrictedPicklist = restrictedPicklist;
    }

    public List<PickListEntry> getPicklistValues() {
        return this.picklistValues;
    }

    public void setPicklistValues(final List<PickListEntry> picklistValues) {
        this.picklistValues = picklistValues;
    }

    public boolean isDependentPicklist() {
        return this.dependentPicklist;
    }

    public void setDependentPicklist(final boolean dependentPicklist) {
        this.dependentPicklist = dependentPicklist;
    }

    public String[] getReferenceTo() {
        return this.referenceTo;
    }

    public void setReferenceTo(final String[] referenceTo) {
        this.referenceTo = referenceTo;
    }

    public String getRelationshipName() {
        return this.relationshipName;
    }

    public void setRelationshipName(final String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public int getRelationshipOrder() {
        return this.relationshipOrder;
    }

    public void setRelationshipOrder(final int relationshipOrder) {
        this.relationshipOrder = relationshipOrder;
    }

    public boolean isWriteRequiresMasterRead() {
        return this.writeRequiresMasterRead;
    }

    public void setWriteRequiresMasterRead(final boolean writeRequiresMasterRead) {
        this.writeRequiresMasterRead = writeRequiresMasterRead;
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

    public int getDigits() {
        return this.digits;
    }

    public void setDigits(final int digits) {
        this.digits = digits;
    }

    public boolean isGroupable() {
        return this.groupable;
    }

    public void setGroupable(final boolean groupable) {
        this.groupable = groupable;
    }
}
