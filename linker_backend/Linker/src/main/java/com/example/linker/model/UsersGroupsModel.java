package com.example.linker.model;

import com.example.linker.model.id.UsersGroupsId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@Entity
@Table(name="users_chatgroups")
@IdClass(UsersGroupsId.class)
public class UsersGroupsModel extends GenericModel {
    @Id
    private long id_user;
    @Id
    private long id_group;
}