package com.example.linker.controller;

import com.example.linker.dto.CommentsDto;
import com.example.linker.model.CommentsModel;
import com.example.linker.payload.comment.CommentsPayload;
import com.example.linker.repository.CommentsRepository;
import com.example.linker.service.CommentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController extends GenericController<CommentsModel, CommentsDto, CommentsPayload, Long> {

    public CommentsController(CommentsRepository repository) {
        super(new CommentsService(repository));
    }

    @GetMapping("/post/{id_post}")
    public List<CommentsDto> getCommentsFromPost(@PathVariable("id_post") final Long id_post) {
        List<Long> listComments = ((CommentsService)service).getCommentsFromPost(id_post);
        return service.getAllById(listComments);
    }
}