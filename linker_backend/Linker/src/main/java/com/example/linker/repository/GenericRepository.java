package com.example.linker.repository;

import com.example.linker.model.GenericModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericModel, G> extends CrudRepository<T, G> {}
