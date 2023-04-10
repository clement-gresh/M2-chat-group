package com.example.linker.repository;

import com.example.linker.model.UsersModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends GenericRepository<UsersModel, Long> {
    @Query(value="Select * FROM users where username = ?1", nativeQuery=true)
    UsersModel getByUsername(String username);
}
