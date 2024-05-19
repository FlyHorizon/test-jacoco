package org.study.springbootmybatis.model.po;

import lombok.Data;
import org.study.springbootmybatis.model.pojo.UserInfo;

@Data
public class UserInfoCom {

    private int UserId;

    private String UsrName;

    private UserInfo userInfo;
}
