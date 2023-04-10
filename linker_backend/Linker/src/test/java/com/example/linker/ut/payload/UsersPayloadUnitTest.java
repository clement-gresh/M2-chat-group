package com.example.linker.ut.payload;

import com.example.linker.model.UsersModel;
import com.example.linker.payload.user.UsersCreatePayload;
import com.example.linker.payload.user.UsersUpdatePayload;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersPayloadUnitTest {
    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void UsersCreatePayloadToModelTest() throws ParseException {
        UsersCreatePayload userCreatePayload = new UsersCreatePayload();
        userCreatePayload.setUsername("daar");
        userCreatePayload.setPassword("pwd");
        userCreatePayload.setEmail("darr@daar.com");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        userCreatePayload.setBirthday(formatter.parse("1989-10-02"));
        userCreatePayload.setFirstname("firstname");
        userCreatePayload.setLastname("lastname");
        userCreatePayload.setTelephone(331045203040L);

        UsersModel model = modelMapper.map(userCreatePayload, UsersModel.class);

        assertEquals(userCreatePayload.getUsername(), model.getUsername());
        assertEquals(userCreatePayload.getPassword(), model.getPassword());
        assertEquals(userCreatePayload.getEmail(), model.getEmail());
        assertEquals(userCreatePayload.getBirthday(), model.getBirthday());
        assertEquals(userCreatePayload.getFirstname(), model.getFirstname());
        assertEquals(userCreatePayload.getLastname(), model.getLastname());
        assertEquals(userCreatePayload.getTelephone(), model.getTelephone());
    }

    @Test
    public void UsersUpdatePayloadToModelTest() throws ParseException {
        UsersUpdatePayload userUpdatePayload = new UsersUpdatePayload();
        userUpdatePayload.setId_user(1);
        userUpdatePayload.setUsername("daar");
        userUpdatePayload.setPassword("pwd");
        userUpdatePayload.setEmail("darr@daar.com");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        userUpdatePayload.setBirthday(formatter.parse("1989-10-02"));
        userUpdatePayload.setFirstname("firstname");
        userUpdatePayload.setLastname("lastname");
        userUpdatePayload.setTelephone(331045203040L);

        UsersModel model = modelMapper.map(userUpdatePayload, UsersModel.class);

        assertEquals(userUpdatePayload.getId_user(), model.getId_user());
        assertEquals(userUpdatePayload.getUsername(), model.getUsername());
        assertEquals(userUpdatePayload.getPassword(), model.getPassword());
        assertEquals(userUpdatePayload.getEmail(), model.getEmail());
        assertEquals(userUpdatePayload.getBirthday(), model.getBirthday());
        assertEquals(userUpdatePayload.getFirstname(), model.getFirstname());
        assertEquals(userUpdatePayload.getLastname(), model.getLastname());
        assertEquals(userUpdatePayload.getTelephone(), model.getTelephone());
    }
}
