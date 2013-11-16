package org.springframework.social.salesforce.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a single result item.
 * 
 * @author Umut Utkan
 */
public class ResultItem {

    private String type;
    private String url;
    private Map attributes;

    public ResultItem(final String type, final String url) {
        this.type = type;
        this.url = url;
        this.attributes = new HashMap();
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Map getAttributes() {
        return this.attributes;
    }

    public void setAttributes(final Map attributes) {
        this.attributes = attributes;
    }

}
