package com.project.webtemplate.entities;

import com.project.webtemplate.config.RoleEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "User_Name", length = 20, unique = true)
    @NotNull
    private String username;

    @Column(name = "User_Password", length = 100)
    @NotNull
    private String password;

    @Column(name = "Role", length = 10)
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public User(){
    }

    public User(String username, String password, RoleEnum role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
