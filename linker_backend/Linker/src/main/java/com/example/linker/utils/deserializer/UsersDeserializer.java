package com.example.linker.utils.deserializer;

import com.example.linker.payload.user.UsersCreatePayload;
import com.example.linker.payload.user.UsersPayload;
import com.example.linker.payload.user.UsersUpdatePayload;

public class UsersDeserializer extends GenericDeserializer<UsersPayload, UsersCreatePayload, UsersUpdatePayload> {
    public UsersDeserializer() {
        super(UsersCreatePayload.class, UsersUpdatePayload.class, "id_user");
    }
}
