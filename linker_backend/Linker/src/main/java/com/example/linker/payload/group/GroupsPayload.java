package com.example.linker.payload.group;

import com.example.linker.payload.GenericPayload;
import com.example.linker.utils.deserializer.GroupsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = GroupsDeserializer.class)
public abstract class GroupsPayload extends GenericPayload {}
