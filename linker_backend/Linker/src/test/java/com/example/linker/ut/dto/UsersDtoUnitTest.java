package com.example.linker.ut.dto;

import com.example.linker.dto.UsersDto;
import com.example.linker.model.UsersModel;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersDtoUnitTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void UsersDtoToModelTest() throws ParseException {
        UsersDto dto = new UsersDto();
        dto.setId_user(1);
        dto.setUsername("daar");
        dto.setPassword("pwd");
        dto.setEmail("darr@daar.com");
        SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        dto.setBirthday(formatter.parse("1989-10-02"));
        dto.setFirstname("firstname");
        dto.setLastname("lastname");
        dto.setTelephone(331045203040L);

        UsersModel model = modelMapper.map(dto, UsersModel.class);

        assertEquals(dto.getId_user(), model.getId_user());
        assertEquals(dto.getUsername(), model.getUsername());
        assertEquals(dto.getPassword(), model.getPassword());
        assertEquals(dto.getEmail(), model.getEmail());
        assertEquals(dto.getBirthday(), model.getBirthday());
        assertEquals(dto.getFirstname(), model.getFirstname());
        assertEquals(dto.getLastname(), model.getLastname());
        assertEquals(dto.getTelephone(), model.getTelephone());
    }

    @Test
    public void UsersModelToDtoTest() throws ParseException {
        UsersModel model = new UsersModel();
        model.setUsername("daar");
        model.setPassword("coucou");
        model.setEmail("darr@daar.com");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        model.setBirthday(formatter.parse("1989-10-02"));
        model.setFirstname("firstname");
        model.setLastname("lastname");
        model.setTelephone(331045203040L);

        UsersDto dto = modelMapper.map(model, UsersDto.class);

        assertEquals(dto.getId_user(), model.getId_user());
        assertEquals(dto.getUsername(), model.getUsername());
        assertEquals(dto.getPassword(), model.getPassword());
        assertEquals(dto.getEmail(), model.getEmail());
        assertEquals(dto.getBirthday(), model.getBirthday());
        assertEquals(dto.getFirstname(), model.getFirstname());
        assertEquals(dto.getLastname(), model.getLastname());
        assertEquals(dto.getTelephone(), model.getTelephone());
    }
}
