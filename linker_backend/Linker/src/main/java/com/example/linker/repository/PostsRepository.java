package com.example.linker.repository;

import com.example.linker.model.PostsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends GenericRepository<PostsModel, Long> {
    @Query(value="Select * FROM posts where id_group = ?1", nativeQuery=true)
    List<PostsModel> getPostsFromGroup(Long id_group);
}