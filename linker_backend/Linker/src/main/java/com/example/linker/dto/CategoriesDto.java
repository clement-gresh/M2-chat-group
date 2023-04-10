package com.example.linker.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
@JsonDeserialize
public class CategoriesDto extends GenericDto {
    private long id_category;
    private String name_category;
}