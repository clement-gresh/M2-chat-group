package com.example.linker.model.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersGroupsId implements Serializable {
    private long id_user;
    private long id_group;
}
