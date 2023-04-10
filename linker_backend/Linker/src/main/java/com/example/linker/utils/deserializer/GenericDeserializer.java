package com.example.linker.utils.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class GenericDeserializer<PAYLOAD, CREATEPAYLOAD extends PAYLOAD, UPDATEPAYLOAD extends PAYLOAD>
        extends JsonDeserializer<PAYLOAD> {
    final Class<CREATEPAYLOAD> createParameterClass;
    final Class<UPDATEPAYLOAD> updateParameterClass;
    final String id_name;

    public GenericDeserializer(Class<CREATEPAYLOAD> createParameterClass, Class<UPDATEPAYLOAD> updateParameterClass, String id_name) {
        this.createParameterClass = createParameterClass;
        this.updateParameterClass = updateParameterClass;
        this.id_name = id_name;
    }

    @Override
    public PAYLOAD deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);
        Class<? extends PAYLOAD> instanceClass = (root.has(id_name)) ? updateParameterClass : createParameterClass;
        return mapper.readValue(root.toString(), instanceClass);
    }
}