package org.springframework.social.salesforce.api.impl.json;

import java.util.Date;

import org.springframework.social.salesforce.api.ApiProfile;
import org.springframework.social.salesforce.api.ChatterStatus;
import org.springframework.social.salesforce.api.UserPhoto;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Mixin for {@link org.springframework.social.salesforce.api.Identity}.
 */
public final class IdentityMixin {

    @JsonProperty("id")
    String id;

    @JsonProperty("asserted_user")
    Boolean assertedUser;

    @JsonProperty("user_id")
    String userId;
    
    @JsonProperty("username")
    String username;

    @JsonProperty("organization_id")
    String organizationId;

    @JsonProperty("nick_name")
    String nickName;

    @JsonProperty("display_name")
    String displayName;

    @JsonProperty("email")
    String email;

    @JsonProperty("status")
    ChatterStatus status;

    @JsonProperty("photos")
    UserPhoto photos;

    @JsonProperty("urls")
    ApiProfile apiProfile;

    @JsonProperty("active")
    Boolean active;

    @JsonProperty("user_type")
    String userType;

    @JsonProperty("language")
    String language;

    @JsonProperty("locale")
    String locale;

    @JsonProperty("utcOffset")
    Integer utcOffset;

    @JsonProperty("last_modified_date")
    Date modifiedAt;
    
    private IdentityMixin() {
        
    }
}
