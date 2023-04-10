package com.example.linker.controller;

import com.example.linker.dto.UsersGroupsDto;
import com.example.linker.model.UsersGroupsModel;
import com.example.linker.model.id.UsersGroupsId;
import com.example.linker.payload.usergroup.UsersGroupsPayload;
import com.example.linker.repository.UsersGroupsRepository;
import com.example.linker.service.UsersGroupsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users_groups")
public class UsersGroupsController extends GenericController<UsersGroupsModel, UsersGroupsDto, UsersGroupsPayload, UsersGroupsId> {

    public UsersGroupsController(UsersGroupsRepository repository) {
        super(new UsersGroupsService(repository));
    }
}