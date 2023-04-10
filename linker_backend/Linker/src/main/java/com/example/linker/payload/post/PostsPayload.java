package com.example.linker.payload.post;

import com.example.linker.payload.GenericPayload;
import com.example.linker.utils.deserializer.PostsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PostsDeserializer.class)
public abstract class PostsPayload extends GenericPayload {}
