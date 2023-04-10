package com.example.linker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@Entity
@Table(name="chatgroups")
public class GroupsModel extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_group;
    private String name_g;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private long id_owner;
    private String description;
    private long id_category;
}
