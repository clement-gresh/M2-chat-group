package com.example.linker.utils.deserializer;

import com.example.linker.payload.category.CategoriesCreatePayload;
import com.example.linker.payload.category.CategoriesPayload;
import com.example.linker.payload.category.CategoriesUpdatePayload;

public class CategoriesDeserializer extends GenericDeserializer<CategoriesPayload, CategoriesCreatePayload, CategoriesUpdatePayload> {
    public CategoriesDeserializer() {
        super(CategoriesCreatePayload.class, CategoriesUpdatePayload.class, "id_category");
    }
}