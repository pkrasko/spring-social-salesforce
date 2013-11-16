package org.springframework.social.salesforce.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Util for extracting properties from a JsonNode.
 */
final class DeserializationUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.registerModule(new SalesforceModule());
    }

    private DeserializationUtils() {

    }

    /**
     * Deserialize from JsonNode.
     * 
     * @param jp parser
     * @param ctxt context
     * @param propertyName Property to find
     * @param typeReference Type
     * @return Object
     * @throws IOException exception
     * @param <T> Type
     */
    public static <T> T deserializeFromDataNode(final JsonParser jp, final DeserializationContext ctxt, final String propertyName,
            final TypeReference<T> typeReference) throws IOException {
        if (jp.hasCurrentToken() && jp.getCurrentToken().equals(JsonToken.START_OBJECT)) {
            final JsonNode dataNode = jp.readValueAs(JsonNode.class);
            if (dataNode.has(propertyName)) {
                return OBJECT_MAPPER.reader(typeReference).<T>readValue(dataNode.get(propertyName));
            }
            return null;
        }
        throw ctxt.mappingException("Expected JSON object");
    }

}
