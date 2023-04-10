package com.example.linker.repository;

import com.example.linker.model.GroupsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepository extends GenericRepository<GroupsModel, Long> {
    @Query(value="Select * FROM chatgroups where id_category = ?1", nativeQuery=true)
    List<GroupsModel> getByCategory(Long id_category);
}