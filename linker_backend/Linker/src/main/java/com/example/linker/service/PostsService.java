package com.example.linker.service;

import com.example.linker.dto.PostsDto;
import com.example.linker.model.PostsModel;
import com.example.linker.payload.post.PostsPayload;
import com.example.linker.repository.PostsRepository;

import java.util.List;

public class PostsService extends GenericService<PostsModel, PostsDto, PostsPayload, Long>{
    public PostsService(PostsRepository repository) {
        super(PostsModel.class, PostsDto.class, repository);
    }

    public List<Long> getPostsFromGroup(Long id_group) {
        List<PostsModel> postsModels = ((PostsRepository)repository).getPostsFromGroup(id_group);
        return postsModels.stream().map(PostsModel::getId_post).toList();
    }
}
