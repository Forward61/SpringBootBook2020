package com.freedom.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "t_customerinfo")
public class CustomerInfo {

    @Id
    private int cid;
    private String certificatetype;
    private String certificateno;
    private String certificatename;
    private String gender;
    private int age;
    private String address;
    private String phoneno;
    private String email;
    private String state;


}
