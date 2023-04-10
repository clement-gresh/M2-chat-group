package com.example.linker.utils.deserializer;

import com.example.linker.payload.comment.CommentsCreatePayload;
import com.example.linker.payload.comment.CommentsPayload;
import com.example.linker.payload.comment.CommentsUpdatePayload;

public class CommentsDeserializer extends GenericDeserializer<CommentsPayload, CommentsCreatePayload, CommentsUpdatePayload> {
    public CommentsDeserializer() {
        super(CommentsCreatePayload.class, CommentsUpdatePayload.class, "id_comment");
    }
}