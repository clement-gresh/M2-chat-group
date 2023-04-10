package com.example.linker.controller;

import com.example.linker.dto.PostsDto;
import com.example.linker.model.PostsModel;
import com.example.linker.payload.post.PostsPayload;
import com.example.linker.repository.PostsRepository;
import com.example.linker.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController extends GenericController<PostsModel, PostsDto, PostsPayload, Long> {

    public PostsController(PostsRepository repository) {
        super(new PostsService(repository));
    }

    @GetMapping("/group/{id_group}")
    public List<PostsDto> getPostsFromGroup(@PathVariable("id_group") final Long id_group) {
        List<Long> listPosts = ((PostsService)service).getPostsFromGroup(id_group);
        return service.getAllById(listPosts);
    }

}