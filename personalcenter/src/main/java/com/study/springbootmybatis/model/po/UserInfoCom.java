package com.study.springbootmybatis.model.po;

import lombok.Data;
import com.study.springbootmybatis.model.pojo.UserInfo;

@Data
public class UserInfoCom {

    private int UserId;

    private String UsrName;

    private UserInfo userInfo;
}
