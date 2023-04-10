package com.example.linker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
@JsonDeserialize
public class GroupsDto extends GenericDto {
    private long id_group;
    private String name_g;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private long id_owner;
    private String description;
    private long id_category;
}