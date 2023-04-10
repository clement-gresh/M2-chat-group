package com.example.linker.service;

import com.example.linker.dto.UsersDto;
import com.example.linker.model.UsersModel;
import com.example.linker.payload.user.UsersPayload;
import com.example.linker.payload.user.UsersLoginPayload;
import com.example.linker.repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UsersService extends GenericService<UsersModel, UsersDto, UsersPayload, Long>{
    public UsersService(UsersRepository repository) {
        super(UsersModel.class, UsersDto.class, repository);
    }

    @Override
    public UsersDto save(UsersPayload payload) {
        payload.encryptPassword();
        UsersModel model = repository.save(modelMapper.map(payload, UsersModel.class));
        return modelMapper.map(model, dtoParameterClass);
    }

    public UsersDto login(UsersLoginPayload payload) {
        UsersModel actualModel = ((UsersRepository)repository).getByUsername(payload.getUsername());
        System.out.println("actual model: " + actualModel);
        if(BCrypt.checkpw(payload.getPassword(), actualModel.getPassword())){
            System.out.println("right pwd");
            return modelMapper.map(actualModel, dtoParameterClass);
        } else {
            System.out.println("wrong pwd");
            return new UsersDto();
        }
    }
}
