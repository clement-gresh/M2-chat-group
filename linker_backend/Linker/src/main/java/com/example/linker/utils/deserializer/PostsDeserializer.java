package com.example.linker.utils.deserializer;

import com.example.linker.payload.post.PostsCreatePayload;
import com.example.linker.payload.post.PostsPayload;
import com.example.linker.payload.post.PostsUpdatePayload;

public class PostsDeserializer extends GenericDeserializer<PostsPayload, PostsCreatePayload, PostsUpdatePayload> {
    public PostsDeserializer() {
        super(PostsCreatePayload.class, PostsUpdatePayload.class, "id_post");
    }
}