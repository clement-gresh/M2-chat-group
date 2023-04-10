package com.example.linker.payload.user;

import com.example.linker.payload.GenericPayload;
import com.example.linker.utils.deserializer.UsersDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = UsersDeserializer.class)
public abstract class UsersPayload extends GenericPayload {
    public abstract void encryptPassword();
}
