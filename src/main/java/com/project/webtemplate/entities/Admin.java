package com.project.webtemplate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    private int Id;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "User_Password")
    private String userPass;

    public Admin(){
    }

    public Admin(String userName, String userPass){
        this.userName = userName;
        this.userPass = userPass;
    }

}
