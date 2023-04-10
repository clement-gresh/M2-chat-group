package com.example.linker.payload.usergroup;

import com.example.linker.payload.GenericPayload;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@EqualsAndHashCode(callSuper = false)
// @JsonDeserialize(using = UsersDeserializer.class) // debug : create a deserializer ?
public class UsersGroupsPayload extends GenericPayload {
    private long id_user;
    private long id_group;
}