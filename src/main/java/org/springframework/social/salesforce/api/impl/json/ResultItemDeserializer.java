package org.springframework.social.salesforce.api.impl.json;

import java.io.IOException;
import java.util.Map;

import org.springframework.social.salesforce.api.QueryResult;
import org.springframework.social.salesforce.api.ResultItem;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Deserializer for {@link org.springframework.social.salesforce.api.ResultItem}.
 * 
 * @author Umut Utkan
 */
public class ResultItemDeserializer extends JsonDeserializer<ResultItem> {

    public ResultItemDeserializer() {
        super();
    }

    @Override
    public ResultItem deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new SalesforceModule());
        jp.setCodec(mapper);
        
        final JsonNode jsonNode = jp.readValueAsTree();
        final Map<String, Object> map = mapper.readValue(jsonNode.traverse(), new TypeReference<Map<String, Object>>() { });
        final ResultItem item = new ResultItem((String)((Map)map.get("attributes")).get("type"),
                (String)((Map)map.get("attributes")).get("url"));
        map.remove("attributes");
        // item.setAttributes(map);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                @SuppressWarnings("unchecked")
                final Map<String, Object> inner = (Map)entry.getValue();
                if (inner.get("records") != null) {
                    item.getAttributes().put(entry.getKey(), mapper.readValue(jsonNode.get(entry.getKey()).traverse(), QueryResult.class));
                } else {
                    item.getAttributes().put(entry.getKey(), mapper.readValue(jsonNode.get(entry.getKey()).traverse(), ResultItem.class));
                }
            } else {
                item.getAttributes().put(entry.getKey(), entry.getValue());
            }
        }

        return item;
    }

}
