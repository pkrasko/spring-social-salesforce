package org.springframework.social.salesforce.api;


/**
 * Describes a profile for a user.
 * 
 * @author Umut Utkan
 */
public class SalesforceProfile {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Photo photo;


    public SalesforceProfile(final String id, final String firstName, final String lastName, final String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Photo getPhoto() {
        return this.photo;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getUsername() {
        return this.id;
    }

}
