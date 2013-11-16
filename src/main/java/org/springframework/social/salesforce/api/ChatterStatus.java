package org.springframework.social.salesforce.api;

import java.util.Date;

/**
 * Chatter status.
 */
public final class ChatterStatus extends AbstractSalesforceObject {

    private Date createdDate;
    private String body;

    public ChatterStatus() {

    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

}
