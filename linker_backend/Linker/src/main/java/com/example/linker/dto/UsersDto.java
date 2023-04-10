package com.example.linker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonSerialize
@JsonDeserialize
public class UsersDto extends GenericDto {
    private long id_user;
    private String username;
    private String password;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String firstname;
    private String lastname;
    private long telephone;
}
