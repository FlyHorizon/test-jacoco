package org.study.springbootmybatis.model.pojo;

public class User {
    private Integer userId;

    private String usrName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName == null ? null : usrName.trim();
    }
}