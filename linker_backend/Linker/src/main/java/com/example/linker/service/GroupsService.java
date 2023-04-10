package com.example.linker.service;

import com.example.linker.dto.GroupsDto;
import com.example.linker.model.GroupsModel;
import com.example.linker.payload.group.GroupsPayload;
import com.example.linker.repository.GroupsRepository;

import java.util.List;

public class GroupsService extends GenericService<GroupsModel, GroupsDto, GroupsPayload, Long>{
    public GroupsService(GroupsRepository repository) {
        super(GroupsModel.class, GroupsDto.class, repository);
    }

    public List<Long> getGroupsFromCategory(Long id_category) {
        List<GroupsModel> groupsModels = ((GroupsRepository)repository).getByCategory(id_category);
        return groupsModels.stream().map(GroupsModel::getId_group).toList();
    }
}