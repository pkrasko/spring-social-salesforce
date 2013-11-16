package org.springframework.social.salesforce.api;

import java.io.Serializable;

/**
 * User images.
 */
public final class UserPhoto implements Serializable {

    /** SN. */
    private static final long serialVersionUID = -8552042108340518741L;

    private String thumbnail;
    private String picture;

    public UserPhoto() {

    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(final String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(final String picture) {
        this.picture = picture;
    }

}
