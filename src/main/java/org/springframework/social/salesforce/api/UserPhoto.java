/*
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api;


/**
 * User images.
 */
public final class UserPhoto {

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
