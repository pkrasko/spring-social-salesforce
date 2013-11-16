package org.springframework.social.salesforce.api;

import java.util.List;
import java.util.Map;

/**
 * Describes the Chatter status of a Salesforce user.
 * 
 * @author Umut Utkan
 */
public class Status {

    private String text;
    private List<Map<String, String>> segments;

    public Status(final String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public List<Map<String, String>> getSegments() {
        return this.segments;
    }

    public void setSegments(final List<Map<String, String>> segments) {
        this.segments = segments;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Status [text=");
        builder.append(this.text);
        builder.append(", segments=");
        builder.append(this.segments);
        builder.append("]");
        return builder.toString();
    }

}
