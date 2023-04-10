package com.example.linker.payload.group;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@EqualsAndHashCode(callSuper = false)
public class GroupsCreatePayload extends GroupsPayload {
    private String name_g;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
    private long id_owner;
    private String description;
    private long id_category;
}
