package org.springframework.social.salesforce.api;

import java.util.Map;

/**
 * Describes the summary of an SObject.
 * 
 * @author Umut Utkan
 */
public class SObjectSummary {

    private String name;
    private String label;
    private boolean updateable;
    private String keyPrefix;
    private boolean custom;
    private Map<String, String> urls;
    private boolean searchable;
    private String labelPlural;
    private boolean layoutable;
    private boolean activateable;
    private boolean createable;
    private boolean deprecatedAndHidden;
    private boolean customSetting;
    private boolean deletable;
    private boolean feedEnabled;
    private boolean mergeable;
    private boolean queryable;
    private boolean replicateable;
    private boolean retrieveable;
    private boolean undeletable;
    private boolean triggerable;

    public SObjectSummary() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public boolean isUpdateable() {
        return this.updateable;
    }

    public void setUpdateable(final boolean updateable) {
        this.updateable = updateable;
    }

    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    public void setKeyPrefix(final String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public boolean isCustom() {
        return this.custom;
    }

    public void setCustom(final boolean custom) {
        this.custom = custom;
    }

    public Map<String, String> getUrls() {
        return this.urls;
    }

    public void setUrls(final Map<String, String> urls) {
        this.urls = urls;
    }

    public boolean isSearchable() {
        return this.searchable;
    }

    public void setSearchable(final boolean searchable) {
        this.searchable = searchable;
    }

    public String getLabelPlural() {
        return this.labelPlural;
    }

    public void setLabelPlural(final String labelPlural) {
        this.labelPlural = labelPlural;
    }

    public boolean isLayoutable() {
        return this.layoutable;
    }

    public void setLayoutable(final boolean layoutable) {
        this.layoutable = layoutable;
    }

    public boolean isActivateable() {
        return this.activateable;
    }

    public void setActivateable(final boolean activateable) {
        this.activateable = activateable;
    }

    public boolean isCreateable() {
        return this.createable;
    }

    public void setCreateable(final boolean createable) {
        this.createable = createable;
    }

    public boolean isDeprecatedAndHidden() {
        return this.deprecatedAndHidden;
    }

    public void setDeprecatedAndHidden(final boolean deprecatedAndHidden) {
        this.deprecatedAndHidden = deprecatedAndHidden;
    }

    public boolean isCustomSetting() {
        return this.customSetting;
    }

    public void setCustomSetting(final boolean customSetting) {
        this.customSetting = customSetting;
    }

    public boolean isDeletable() {
        return this.deletable;
    }

    public void setDeletable(final boolean deletable) {
        this.deletable = deletable;
    }

    public boolean isFeedEnabled() {
        return this.feedEnabled;
    }

    public void setFeedEnabled(final boolean feedEnabled) {
        this.feedEnabled = feedEnabled;
    }

    public boolean isMergeable() {
        return this.mergeable;
    }

    public void setMergeable(final boolean mergeable) {
        this.mergeable = mergeable;
    }

    public boolean isQueryable() {
        return this.queryable;
    }

    public void setQueryable(final boolean queryable) {
        this.queryable = queryable;
    }

    public boolean isReplicateable() {
        return this.replicateable;
    }

    public void setReplicateable(final boolean replicateable) {
        this.replicateable = replicateable;
    }

    public boolean isRetrieveable() {
        return this.retrieveable;
    }

    public void setRetrieveable(final boolean retrieveable) {
        this.retrieveable = retrieveable;
    }

    public boolean isUndeletable() {
        return this.undeletable;
    }

    public void setUndeletable(final boolean undeletable) {
        this.undeletable = undeletable;
    }

    public boolean isTriggerable() {
        return this.triggerable;
    }

    public void setTriggerable(final boolean triggerable) {
        this.triggerable = triggerable;
    }

}
