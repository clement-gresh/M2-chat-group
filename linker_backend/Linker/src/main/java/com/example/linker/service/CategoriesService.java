package com.example.linker.service;

import com.example.linker.dto.CategoriesDto;
import com.example.linker.model.CategoriesModel;
import com.example.linker.payload.category.CategoriesPayload;
import com.example.linker.repository.CategoriesRepository;

public class CategoriesService extends GenericService<CategoriesModel, CategoriesDto, CategoriesPayload, Long>{
    public CategoriesService(CategoriesRepository repository) {
        super(CategoriesModel.class, CategoriesDto.class, repository);
    }
}