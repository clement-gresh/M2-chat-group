package com.example.linker.utils.deserializer;

import com.example.linker.payload.group.GroupsCreatePayload;
import com.example.linker.payload.group.GroupsPayload;
import com.example.linker.payload.group.GroupsUpdatePayload;

public class GroupsDeserializer extends GenericDeserializer<GroupsPayload, GroupsCreatePayload, GroupsUpdatePayload> {
    public GroupsDeserializer() {
        super(GroupsCreatePayload.class, GroupsUpdatePayload.class, "id_group");
    }
}