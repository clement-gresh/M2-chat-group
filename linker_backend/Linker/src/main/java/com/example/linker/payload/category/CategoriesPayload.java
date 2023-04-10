package com.example.linker.payload.category;

import com.example.linker.payload.GenericPayload;
import com.example.linker.utils.deserializer.CategoriesDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CategoriesDeserializer.class)
public abstract class CategoriesPayload extends GenericPayload {}
