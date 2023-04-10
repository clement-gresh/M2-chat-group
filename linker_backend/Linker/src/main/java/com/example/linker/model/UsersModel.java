package com.example.linker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@JsonDeserialize
@Entity
@Table(name="users")
public class UsersModel extends GenericModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    //@Column(name="first_name")
    private String username;
    private String password;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    private String firstname;
    private String lastname;
    private long telephone;
}
