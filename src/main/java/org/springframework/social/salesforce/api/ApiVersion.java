package org.springframework.social.salesforce.api;


/**
 * Describes a particular API version.
 * 
 * @author Umut Utkan
 */
public class ApiVersion {

    private String label;

    private String version;

    private String url;

    public ApiVersion(final String version, final String label, final String url) {
        this.version = version;
        this.label = label;
        this.url = url;
    }

    public String getLabel() {
        return this.label;
    }

    public String getVersion() {
        return this.version;
    }

    public String getUrl() {
        return this.url;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ApiVersion [label=");
        builder.append(this.label);
        builder.append(", version=");
        builder.append(this.version);
        builder.append(", url=");
        builder.append(this.url);
        builder.append("]");
        return builder.toString();
    }
}
