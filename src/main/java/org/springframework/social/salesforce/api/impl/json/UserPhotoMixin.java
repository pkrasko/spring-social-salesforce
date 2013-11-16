/*
 * Copyright 2013 Mobile Iron, Inc.
 * All rights reserved.
 */

package org.springframework.social.salesforce.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Mixin for {@link org.springframework.social.salesforce.api.UserPhoto}.
 */
public final class UserPhotoMixin {

    @JsonProperty("thumbnail")
    String thumbnail;
    
    @JsonProperty("picture")
    String picture;
    
    private UserPhotoMixin() {
        
    }
}
