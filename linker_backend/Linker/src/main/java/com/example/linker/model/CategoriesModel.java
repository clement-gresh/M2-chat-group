package com.example.linker.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
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
@Table(name="categories")
public class CategoriesModel extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_category;
    private String name_category;
}
