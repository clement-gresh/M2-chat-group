package com.example.linker.service;

import com.example.linker.dto.CommentsDto;
import com.example.linker.model.CommentsModel;
import com.example.linker.payload.comment.CommentsPayload;
import com.example.linker.repository.CommentsRepository;

import java.util.List;

public class CommentsService extends GenericService<CommentsModel, CommentsDto, CommentsPayload, Long>{
    public CommentsService(CommentsRepository repository) {
        super(CommentsModel.class, CommentsDto.class, repository);
    }

    public List<Long> getCommentsFromPost(Long id_post) {
        List<CommentsModel> commentsModels = ((CommentsRepository)repository).getCommentsFromPost(id_post);
        return commentsModels.stream().map(CommentsModel::getId_comment).toList();
    }
}