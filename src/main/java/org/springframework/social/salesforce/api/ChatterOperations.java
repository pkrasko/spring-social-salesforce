package org.springframework.social.salesforce.api;

/**
 * Defines operations for interacting with the Chatter API.
 *
 * @author Umut Utkan
 */
public interface ChatterOperations {

    /**
     * Retrieves current users's profile.
     *
     * @return user profile
     */
    SalesforceProfile getUserProfile();

    /**
     * Retrieves the given user's profile.
     *
     * @param userId The user identifier
     * @return user profile
     */
    SalesforceProfile getUserProfile(String userId);

    /**
     * Retrieves current user's status.
     *
     * @return status
     */
    Status getStatus();

    /**
     * Retrieves the given user's status.
     *
     * @param userId The user identifier
     * @return status
     */
    Status getStatus(String userId);

    /**
     * Updates current user's status with the given message.
     *
     * @param message The new status message
     * @return status
     */
    Status updateStatus(String message);

    /**
     * Updates the given user's status with the given message.
     *
     * @param userId The user identifier
     * @param message The new status message
     * @return status
     */
    Status updateStatus(String userId, String message);

}
