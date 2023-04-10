package com.example.linker.repository;

import com.example.linker.model.CategoriesModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends GenericRepository<CategoriesModel, Long> {
}
