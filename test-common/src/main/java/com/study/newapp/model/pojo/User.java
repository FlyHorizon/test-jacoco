package com.study.newapp.model.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String usrName;
    private String usrPassword;
    private Integer usrType;
}
