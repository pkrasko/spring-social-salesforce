/**
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api;



/**
 * Enum for Salesforce Organization types.
 */
public enum SalesforceOrgType {

    TEAM_EDITION("Team Edition"),
    PROFESSIONAL_EDITION("Professional Edition"),
    ENTERPRISE_EDITION("Enterprise Edition"),
    DEVELOPER_EDITION("Developer Edition"),
    PERSONAL_EDITION("Personal Edition"),
    UNLIMITED_EDITION("Unlimited Edition"),
    CONTACT_MANAGER_EDITION("Contact Manager Edition"),
    BASE_EDITION("Base Edition");

    private final String description;

    private SalesforceOrgType(final String description) {
        this.description = description;
    }


    public String getDescription() {
        return this.description;
    }

}
