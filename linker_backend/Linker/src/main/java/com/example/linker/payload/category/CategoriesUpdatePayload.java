package com.example.linker.payload.category;

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
public class CategoriesUpdatePayload extends CategoriesPayload {
    private long id_category;
    private String name_category;
}
