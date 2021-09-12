package org.montrealjug.meetups.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.time.Instant;

public class EventDeserializer extends JsonDeserializer {

    @Override
    public Event deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Event event = new Event();
        TreeNode treeNode = jsonParser.getCodec().readTree(jsonParser);
        TreeNode venueTreeNode = treeNode.get("venue");
        if (venueTreeNode != null && venueTreeNode.size() > 0) {
            if (venueTreeNode.get("name") instanceof TextNode) {
                TextNode name = (TextNode) venueTreeNode.get("name");
                event.setVenueName(name.asText());
            }
        }
        if (treeNode.get("time") instanceof LongNode) {
            LongNode time = (LongNode) treeNode.get("time");
            event.setInstant(Instant.ofEpochMilli(time.longValue()));
        }
        if (treeNode.get("name") instanceof TextNode) {
            TextNode name = (TextNode) treeNode.get("name");
            event.setName(name.asText());
        }
        return event;
    }
}
