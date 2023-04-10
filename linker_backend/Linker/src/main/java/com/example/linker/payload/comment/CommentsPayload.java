package com.example.linker.payload.comment;

import com.example.linker.payload.GenericPayload;
import com.example.linker.utils.deserializer.CommentsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CommentsDeserializer.class)
public abstract class CommentsPayload extends GenericPayload {}
