package com.example.linker.controller;


import com.example.linker.dto.GroupsDto;
import com.example.linker.model.GroupsModel;
import com.example.linker.payload.group.GroupsPayload;
import com.example.linker.repository.GroupsRepository;
import com.example.linker.repository.UsersGroupsRepository;
import com.example.linker.service.GroupsService;
import com.example.linker.service.UsersGroupsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupsController extends GenericController<GroupsModel, GroupsDto, GroupsPayload, Long> {
    protected final UsersGroupsService usersGroupsService;
    public GroupsController(GroupsRepository repository,
                            UsersGroupsRepository usersGroupsRepository) {
        super(new GroupsService(repository));
        this.usersGroupsService = new UsersGroupsService(usersGroupsRepository);
    }

    @GetMapping("/user/{id_user}")
    public List<GroupsDto> getGroupsFromUser(@PathVariable("id_user") final Long id_user) {
        List<Long> listGroups = usersGroupsService.getGroupsFromUser(id_user);
        return service.getAllById(listGroups);
    }

    @GetMapping("/category/{id_category}")
    public List<GroupsDto> getGroupsFromCategory(@PathVariable("id_category") final Long id_category) {
        List<Long> listGroups = ((GroupsService)service).getGroupsFromCategory(id_category);
        return service.getAllById(listGroups);
    }
}