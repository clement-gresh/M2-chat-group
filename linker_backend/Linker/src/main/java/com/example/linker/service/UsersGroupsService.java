package com.example.linker.service;

import com.example.linker.dto.UsersGroupsDto;
import com.example.linker.model.UsersGroupsModel;
import com.example.linker.model.id.UsersGroupsId;
import com.example.linker.payload.usergroup.UsersGroupsPayload;
import com.example.linker.repository.UsersGroupsRepository;

import java.util.List;

public class UsersGroupsService extends GenericService<UsersGroupsModel, UsersGroupsDto,
                                                        UsersGroupsPayload, UsersGroupsId>{
    public UsersGroupsService(UsersGroupsRepository repository) {
        super(UsersGroupsModel.class, UsersGroupsDto.class, repository);
    }

    public List<Long> getUsersFromGroup(Long id_group) {
        List<UsersGroupsModel> usersGroupsModels = ((UsersGroupsRepository)repository).getUsersFromGroup(id_group);
        return usersGroupsModels.stream().map(UsersGroupsModel::getId_user).toList();
    }

    public List<Long> getGroupsFromUser(Long id_user) {
        List<UsersGroupsModel> usersGroupsModels = ((UsersGroupsRepository)repository).getGroupsFromUser(id_user);
        return usersGroupsModels.stream().map(UsersGroupsModel::getId_group).toList();
    }
}
