package org.springframework.social.salesforce.api.impl;

import org.springframework.http.HttpMethod;
import org.springframework.social.salesforce.api.SalesforceProfile;
import org.springframework.social.salesforce.api.Status;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

/**
 * Chatter template test.
 * 
 * @author Umut Utkan
 */
public class ChatterTemplateTest extends AbstractSalesforceTest {

    @Test
    public void getProfile() {
        this.mockServer.expect(requestTo(VERSION_URL + "/chatter/users/me"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("profile.json"), this.responseHeaders));
        final SalesforceProfile profile = this.salesforce.chatterOperations().getUserProfile();
        assertThat(profile.getFullName(), equalTo("Umut Utkan"));
        assertThat(profile.getEmail(), equalTo("umut.utkan@foo.com"));
        assertThat(profile.getId(), equalTo("005A0000001cRuvIAE"));
        assertThat(profile.getUsername(), equalTo("005A0000001cRuvIAE"));
        assertThat(profile.getPhoto().getLargePhotoUrl(), equalTo("https://c.na7.content.force.com/profilephoto/005/F"));
        assertThat(profile.getPhoto().getSmallPhotoUrl(), equalTo("https://c.na7.content.force.com/profilephoto/005/T"));
    }

    @Test
    public void getStatus() {
        this.mockServer.expect(requestTo(VERSION_URL + "/chatter/users/me/status"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withResponse(loadResource("chatter-status.json"), this.responseHeaders));

        final Status status = this.salesforce.chatterOperations().getStatus();
        assertThat(status, notNullValue());
        assertThat(status.getText(), equalTo("I am also working on #hede"));
    }

    @Test
    public void updateStatus() {
        this.mockServer.expect(requestTo(VERSION_URL + "/chatter/users/me/status"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(body("text=Updating+status+via+%23spring-social-salesforce%21"))
                .andRespond(withResponse(loadResource("chatter-status.json"), this.responseHeaders));

        final Status status = this.salesforce.chatterOperations().updateStatus("Updating status via #spring-social-salesforce!");
        assertThat(status, notNullValue());
    }

}
