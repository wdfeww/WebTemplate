package com.project.webtemplate.entities;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

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
