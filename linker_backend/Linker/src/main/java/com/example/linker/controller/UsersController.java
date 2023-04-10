package com.example.linker.controller;

import com.example.linker.dto.UsersDto;
import com.example.linker.model.UsersModel;
import com.example.linker.payload.user.UsersPayload;
import com.example.linker.payload.user.UsersLoginPayload;
import com.example.linker.repository.UsersGroupsRepository;
import com.example.linker.repository.UsersRepository;
import com.example.linker.service.UsersGroupsService;
import com.example.linker.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController extends GenericController<UsersModel, UsersDto, UsersPayload, Long> {
    protected final UsersGroupsService usersGroupsService;

    public UsersController(UsersRepository repository,
                           UsersGroupsRepository usersGroupsRepository) {
        super(new UsersService(repository));
        this.usersGroupsService = new UsersGroupsService(usersGroupsRepository);
    }

    @PostMapping("/login")
    public UsersDto login(@RequestBody UsersLoginPayload payload) {
        return ((UsersService)service).login(payload);
    }

    @GetMapping("/group/{id_group}")
    public List<UsersDto> getUsersFromGroup(@PathVariable("id_group") final Long id_group) {
        List<Long> listUsers = usersGroupsService.getUsersFromGroup(id_group);
        return service.getAllById(listUsers);
    }

}
