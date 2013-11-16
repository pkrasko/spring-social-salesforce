package org.springframework.social.salesforce;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Constants.
 */
@SuppressWarnings("hiding")
public final class SalesforceConstants {
    
    public static final String PROVIDER_ID = "salesforce";
    
    /**
     * Common OAuth constants.
     */
    public final class OAuthProperties {
        
        public static final String URL_AUTHORIZE = "https://login.salesforce.com/services/oauth2/authorize";
        public static final String URL_TOKEN = "https://login.salesforce.com/services/oauth2/token";
        
        private OAuthProperties() {
            
        }
    }
    
    /**
     * Defines well known API Levels.
     */
    public enum ApiLevel {
        V25("25.0"),
        V26("26.0"),
        V27("27.0"),
        V28("28.0"),
        V29("29.0");
        
        private final String version;
        
        private ApiLevel(final String version) {
            this.version = version;
        }
        
        public String getVersion() {
            return this.version;
        }
    }
    
    /**
     * Step 1, Redirect User to Obtain Access Authorization.
     */
    public static final class Authorization {
        
        
        /**
         * Value must be {@code code} for this flow.
         */
        public static final String PARAM_RESPONSE_TYPE = "response_type";

        /**
         * Consumer key from the remote access application definition.
         */
        public static final String PARAM_CLIENT_ID = "client_id";

        /**
         * The scope parameter enables you to fine-tune what the client application can access in a Salesforce
         * organization.
         */
        public static final String PARAM_SCOPE = "scope";

        /**
         * URI to redirect the user to after approval. This must match the value in the Callback URL field in the remote
         * access application definition exactly, or approval fails. This value must be URL encoded.
         */
        public static final String PARAM_REDIRECT_URI = "redirect_uri";

        /**
         * Any state the consumer wants reflected back to it after approval, during the callback. This parameter is
         * optional. This value must be URL encoded.
         */
        public static final String PARAM_STATE = "state";

        /**
         * Determines whether the user should be prompted for login and approval. This parameter is optional. The value
         * must be true or false if specified. Default value is false.
         */
        public static final String PARAM_IMMEDIATE = "immediate";

        /**
         * Changes the login and authorization pages' display type. This parameter is optional.
         */
        public static final String PARAM_DISPLAY = "display";

        /**
         * Specifies how the authorization server prompts the user for reauthentication and reapproval. This parameter
         * is optional.
         */
        public static final String PARAM_PROMPT = "prompt";
        
        
        /**
         * Scope parameter values.
         */
        public enum ScopeParmValue {
            /**
             * Allows access to the current, logged-in user's account over the APIs, such as REST API or Bulk API. 
             * This also includes chatter_api, allowing access to Chatter API resources.
             */
            api,
            
            /**
             * Allows access to only the Chatter API resources.
             */
            chatter_api,
            
            /**
             * Allows access to all data accessible by the logged-in user. full does not return a refresh token. 
             * You must explicitly request the refresh_token scope to get a refresh token.
             */
            full,
            
            /**
             * Allows access only to the identity URL service.
             */
            id,
            
            /**
             * Allows a refresh token to be returned if you are eligible to receive one.
             */
            refresh_token,
            
            /**
             * Allows access to Visualforce pages.
             */
            visualforce,
            
            /**
             * Allows the ability to use the access_token on the Web. This also includes visualforce, 
             * allowing access to Visualforce pages.
             */
            web
        }
        
        /**
         * Display parameter values.
         */
        public enum DisplayParamValue {
            /**
             * Full-page authorization screen. This is the default value if none is specified.
             */
            page,
            
            /**
             * Compact dialog optimized for modern web browser popup windows.
             */
            popup,
            
            /**
             * mobile-optimized dialog designed for modern smartphones such as Android and iPhone.
             */
            touch,
            
            /**
             * mobile optimized dialog designed for less capable smartphones such as BlackBerry OS 5.
             */
            mobile
        }
        
        /**
         * It is valid to pass both values, separated by a space, to require the user to both log in and reauthorize.
         */
        public enum PromptParamValue {
            /**
             * The authorization server must prompt the user for reauthentication, forcing the user to log in again.
             */
            login,
            
            /**
             * The authorization server must prompt the user for reapproval before returning information to the client.
             */
            consent
        }
        
        private Authorization() {
            
        }
    }
    
    /**
     * Step 2, Web Server Received Callback.
     */
    public static final class Callback {
        
        /**
         * Authorization code the consumer must use to obtain the access and refresh tokens.
         */
        public static final String PARAM_CODE = "code";
        
        /**
         * State that was passed into the approval step. This isn't included if the state 
         * parameter wasn't included in the original query string.
         */
        public static final String PARAM_STATE = "state";
        
        /**
         * The error code.
         */
        public static final String PARAM_ERROR = "error";
        
        /**
         * Description of the error with additional information.
         */
        public static final String PARAM_ERROR_DESCRIPTION = "error_description";
        
        /**
         * Possible values for the error parameter.
         */
        public enum ErrorValue {
            access_denied,
            unknown
        }
        
        /**
         * The error description values.
         */
        public enum ErrorDescriptionValue {
            
            unsupported_response_type("response type not supported"),
            invalid_client_id("client identifier invalid"),
            invalid_request("HTTPS required and must use HTTP GET"),
            access_denied("end-user denied authorization"),
            redirect_uri_missing("redirect_uri not provided"),
            redirect_uri_mismatch("redirect_uri mismatch with remote access application definition"),
            immediate_unsuccessful("immediate unsuccessful"),
            invalid_scope("requested scope is invalid, unknown, or malformed"),
            unknown("");
            
            private final String message;
            
            private ErrorDescriptionValue(final String message) {
                this.message = message;
            }
            
            public String getMessage() {
                return this.message;
            }
        }
        
        private Callback() {
            
        }
    }
    
    /**
     * Step 3, Web Server Exchanges Verification Code for Access Token.
     */
    public static final class AccessTokenRequest {
        
        /**
         * Value must be authorization_code for this flow.
         */
        public static final String PARAM_GRANT_TYPE = "grant_type";
        
        /**
         * Consumer key from the remote access application definition.
         */
        public static final String PARAM_CLIENT_ID = "client_id";
        
        /**
         * Consumer secret from the remote access application definition.
         */
        public static final String PARAM_CLIENT_SECRET = "client_secret";
        
        /**
         * URI to redirect the user to after approval. This must match the value in 
         * the Callback URL field in the remote access application definition exactly, 
         * and is the same value sent by the initial redirect.
         */
        public static final String PARAM_REDIRECT_URI = "redirect_uri";
        
        /**
         * Authorization code obtained from the callback after approval.
         */
        public static final String PARAM_CODE = "code";
        
        /**
         * Expected return format. This parameter is optional. The default is json.
         */
        public static final String PARAM_FORMAT = "format";
        
        /** 
         * Refresh token from the approval step.
         */
        public static final String PARAM_REFRESH_TOKEN = "refresh_token";
        
        /**
         * Used during a username-password OAuth 2 flow only.
         */
        public static final String PARAM_USERNAME = "username";
        
        /**
         * Used during a username-password OAuth 2 flow only.
         */
        public static final String PARAM_PASSWORD = "password";
        
        /**
         * Possible values for the {@link AccessTokenRequest#PARAM_FORMAT} parameter.
         */
        public enum FormatParamValue {
            urlencoded,
            json,
            xml
        }
        
        /**
         * Possible values for the {@link AccessTokenRequest#PARAM_GRANT_TYPE} parameter.
         */
        public enum GrantTypeValue {
            authorization_code,
            refresh_token,
            password;
        }
        
        private AccessTokenRequest() {
            
        }
    }
    
    /**
     * Step 4, Salesforce Responds with an Access Token Response.
     */
    public static final class AccessTokenResult {
        
        /**
         * Salesforce session ID that can be used with the Web services API.
         */
        public static final String PARAM_ACCESS_TOKEN = "access_token";
        
        /**
         * Token that can be used in the future to obtain new access tokens (sessions). 
         * This value is a secret. You should treat it like the user's password and 
         * use appropriate measures to protect it.
         */
        public static final String PARAM_REFRESH_TOKEN = "refresh_token";
        
        /**
         * URL indicating the instance of the user's organization. 
         */
        public static final String PARAM_INSTANCE_URL = "instance_url";
        
        /**
         * Identity URL that can be used to both identify the user as well as query 
         * for more information about the user. 
         */
        public static final String PARAM_ID = "id";
        
        /**
         * The scope parameter enables you to fine-tune what the client application can 
         * access in a Salesforce organization.
         */
        public static final String PARAM_SCOPE = "scope";
        
        /**
         * Base64-encoded HMAC-SHA256 signature signed with the consumer's private key 
         * containing the concatenated ID and issued_at. This can be used to verify 
         * the identity URL was not modified since it was sent by the server.
         */
        public static final String PARAM_SIGNATURE = "signature";
        
        /**
         * When the signature was created.
         */
        public static final String PARAM_ISSUED_AT = "issued_at";
        
        /**
         * The error code.
         */
        public static final String PARAM_ERROR = "error";
        
        /**
         * Description of the error with additional information.
         */
        public static final String PARAM_ERROR_DESCRIPTION = "error_description";
        
        /**
         * Defines what the client application can access in a Salesforce organization.
         */
        public enum ScopeParamValue {
            
            /**
             * Allows access to the current, logged-in user's account over the APIs, such as 
             * REST API or Bulk API. This also includes chatter_api, allowing access 
             * to Chatter API resources.
             */
            api,
            
            /**
             * Allows access to only the Chatter API resources.
             */
            chatter_api,
            
            /**
             * Allows access to all data accessible by the logged-in user. full does not return a 
             * refresh token. You must explicitly request the refresh_token scope to get a refresh token.
             */
            full,
            
            /**
             * Allows access only to the identity URL service.
             */
            id,
            
            /**
             * Allows a refresh token to be returned if you are eligible to receive one.
             */
            refresh_token,
            
            /**
             * Allows access to Visualforce pages.
             */
            visualforce,
            
            /**
             * Allows the ability to use the access_token on the Web. This also includes 
             * visualforce, allowing access to Visualforce pages.
             */
            web
        }
        
        private AccessTokenResult() {
            
        }
    }
    
    /**
     * Endpoints.
     */
    public static final class Endpoints {
        
        private static final String ROOT = "/services/data";
        
        private static final Pattern TOKEN_PATTERN = Pattern.compile("\\{([^}]*)\\}");
        
        private Endpoints() {
            
        }
        
        /**
         * Replaces the parameter values in a url path.
         * 
         * @param template Path
         * @param args Variables
         * @return replaced string.
         */
        public static String buildEndpoint(final String template, final String...args) {
            final StringBuffer sb = new StringBuffer();
            final Matcher myMatcher = TOKEN_PATTERN.matcher(template);
            int i = 0;
            while (myMatcher.find()) {
                myMatcher.group(1);
                myMatcher.appendReplacement(sb, "");
                sb.append(args[i]);
                i++;
            }
            myMatcher.appendTail(sb);
            return sb.toString();
        }
       
        
        /**
         * API endpoints.
         */
        public final class Api {
            
            public static final String VERSIONS = ROOT;
            public static final String SERVICES = ROOT + "/v{version}";
            
            private Api() {
                
            }
        }
        
        /**
         * Chatter endpoints.
         */
        public final class Chatter {
            
            
            public static final String ROOT =  "/chatter/users";
            
            public static final String USER_BY_ID = ROOT + "/{id}";
            public static final String USER_STATUS = USER_BY_ID + "/status";
            
            
            private Chatter() {
                
            }
        }
        
        /**
         * Query endpoints.
         */
        public final class Query {
            
            public static final String ROOT = "/query";
            public static final String NEXT_PAGE = ROOT + "/{token}";
            
            private Query() {
                
            }
        }
        
        /**
         * Recent endpoints.
         */
        public final class Recent {
            
            public static final String ROOT = "/recent";
            
            private Recent() {
                
            }
        }
        
        /**
         * Search endpoints.
         */
        public final class Search {
            
            public static final String ROOT = "/search";
            
            private Search() {
                
            }
        }
        
        /**
         * SObjects endpoints.
         */
        public final class SObjects {
            
            public static final String ROOT = "/sobjects";
            public static final String BY_NAME = ROOT + "/{name}";
            public static final String DESCRIBE_BY_NAME = BY_NAME + "/describe";
            public static final String BY_ROW = BY_NAME + "/{id}";
            public static final String BY_BLOB = BY_ROW + "/{field}";
            
            private SObjects() {
                
            }
        }
        
        /**
         * Standard Object names.
         */
        public enum StandardObjects {
            Organization,
            User
        }
        
        
    }

    private SalesforceConstants() {
        
    }
}
