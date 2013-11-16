package org.springframework.social.salesforce.api.impl.json;

import java.io.IOException;

import org.springframework.social.salesforce.api.SalesforceOrgType;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Deserializer for {@link org.springframework.social.salesforce.api.SalesforceOrgType}.
 */
public class SalesforceOrgTypeDeserializer extends JsonDeserializer<SalesforceOrgType> {

    public SalesforceOrgTypeDeserializer() {

    }

    @Override
    public SalesforceOrgType deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SalesforceModule());
        jp.setCodec(mapper);

        final String orgType = mapper.readValue(jp, String.class);
        for (SalesforceOrgType type : SalesforceOrgType.values()) {
            if (type.getDescription().equals(orgType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("invalid string value passed: " + orgType);
    }

}
