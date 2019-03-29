package com.bellacode.homebudget.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull(message = "Field 'name' can not be empty")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Field 'email' can not be empty")
    @Email
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @NotNull(message = "Field 'password' can not be empty")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Field 'active' can not be empty")
    @Column(name = "active")
    private int active;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;


}
