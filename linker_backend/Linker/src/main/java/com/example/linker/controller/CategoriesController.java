package com.example.linker.controller;

import com.example.linker.dto.CategoriesDto;
import com.example.linker.model.CategoriesModel;
import com.example.linker.payload.category.CategoriesPayload;
import com.example.linker.repository.CategoriesRepository;
import com.example.linker.service.CategoriesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoriesController extends GenericController<CategoriesModel, CategoriesDto, CategoriesPayload, Long> {

    public CategoriesController(CategoriesRepository repository) {
        super(new CategoriesService(repository));
    }
}