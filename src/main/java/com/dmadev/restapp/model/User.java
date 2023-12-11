package com.dmadev.restapp.model;

import com.dmadev.restapp.model.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 characters")
    private String firstName;

    @Column(name="last_name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between  2 and 30 characters")
    private String lastName;

    @Column(name="email")
    @NotEmpty(message = "Email should be valid")
    private String email;

    @Column(name = "password")
    @Size(min=6,max=100,message = "Password should be min 6 characters")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;
}
