package com.example.linker.repository;

import com.example.linker.model.id.UsersGroupsId;
import com.example.linker.model.UsersGroupsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersGroupsRepository extends GenericRepository<UsersGroupsModel, UsersGroupsId> {
    @Query(value="Select * FROM users_chatgroups where id_group = ?1", nativeQuery=true)
    List<UsersGroupsModel> getUsersFromGroup(Long id_group);

    @Query(value="Select * FROM users_chatgroups where id_user = ?1", nativeQuery=true)
    List<UsersGroupsModel> getGroupsFromUser(Long id_user);
}
