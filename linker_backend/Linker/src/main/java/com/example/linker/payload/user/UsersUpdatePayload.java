package com.example.linker.payload.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@EqualsAndHashCode(callSuper = false)
public class UsersUpdatePayload extends UsersPayload {
    private long id_user;
    private String username;
    private String password;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String firstname;
    private String lastname;
    private long telephone;

    @Override
    public void encryptPassword() {}
}
