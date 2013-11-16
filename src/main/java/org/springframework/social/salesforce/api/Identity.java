package org.springframework.social.salesforce.api;

import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains additional information about a Salesforce user.
 */
public class Identity extends AbstractSalesforceObject {

    @JsonProperty("id")
    private String id;

    @JsonProperty("asserted_user")
    private Boolean assertedUser;

    @JsonProperty("user_id")
    private String userId;
    
    @JsonProperty("username")
    private String username;

    @JsonProperty("organization_id")
    private String organizationId;

    @JsonProperty("nick_name")
    private String nickName;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private ChatterStatus status;

    @JsonProperty("photos")
    private UserPhoto photos;

    @JsonProperty("urls")
    private ApiProfile apiProfile;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("user_type")
    private String userType;

    @JsonProperty("language")
    private String language;

    @JsonProperty("locale")
    private Locale locale;

    @JsonProperty("utcOffset")
    private Integer utcOffset;

    @JsonProperty("last_modified_date")
    private Date modifiedAt;
    
    public Identity() {
        
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Boolean getAssertedUser() {
        return this.assertedUser;
    }

    public void setAssertedUser(final Boolean assertedUser) {
        this.assertedUser = assertedUser;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(final String organizationId) {
        this.organizationId = organizationId;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(final String nickName) {
        this.nickName = nickName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public ChatterStatus getStatus() {
        return this.status;
    }

    public void setStatus(final ChatterStatus status) {
        this.status = status;
    }

    public UserPhoto getPhotos() {
        return this.photos;
    }

    public void setPhotos(final UserPhoto photos) {
        this.photos = photos;
    }

    public ApiProfile getApiProfile() {
        return this.apiProfile;
    }

    public void setApiProfile(final ApiProfile apiProfile) {
        this.apiProfile = apiProfile;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(final Locale locale) {
        this.locale = locale;
    }

    public Integer getUtcOffset() {
        return this.utcOffset;
    }

    public void setUtcOffset(final Integer utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Date getModifiedAt() {
        return this.modifiedAt;
    }

    public void setModifiedAt(final Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    
}
