package org.springframework.social.salesforce.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User photo object.
 * 
 * @author Umut Utkan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

    private String smallPhotoUrl;

    private String largePhotoUrl;

    public Photo() {

    }

    public String getSmallPhotoUrl() {
        return this.smallPhotoUrl;
    }

    public void setSmallPhotoUrl(final String smallPhotoUrl) {
        this.smallPhotoUrl = smallPhotoUrl;
    }

    public String getLargePhotoUrl() {
        return this.largePhotoUrl;
    }

    public void setLargePhotoUrl(final String largePhotoUrl) {
        this.largePhotoUrl = largePhotoUrl;
    }

}
