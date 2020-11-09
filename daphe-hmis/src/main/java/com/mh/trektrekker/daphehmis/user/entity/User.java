package com.mh.trektrekker.daphehmis.user.entity;

import com.mh.trektrekker.daphehmis.enums.UserType;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String mobileNumber;
    private String address;
    private UserType userType;

}
