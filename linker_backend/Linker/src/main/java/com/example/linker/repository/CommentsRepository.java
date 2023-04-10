package com.example.linker.repository;

import com.example.linker.model.CommentsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends GenericRepository<CommentsModel, Long> {
    @Query(value="Select * FROM comments where id_post = ?1", nativeQuery=true)
    List<CommentsModel> getCommentsFromPost(Long id_post);
}