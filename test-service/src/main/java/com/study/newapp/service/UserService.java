package com.study.newapp.service;

import com.study.newapp.model.pojo.UserInfoCom;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserInfoCom getUserInfo(Integer id){
        System.out.println(id);
        UserInfoCom userInfoCom = new UserInfoCom();
        userInfoCom.setUserId(id);
        userInfoCom.setUsrName("User_" + id);
        return userInfoCom;
    }

    public String getUserName(Integer id) {
        if (id == null) {
            return "Invalid ID";
        }
        if (id <= 0) {
            return "Invalid ID";
        }
        if (id == 1) {
            return "Admin";
        } else if (id == 2) {
            return "Guest";
        } else {
            return "User_" + id;
        }
    }

    public boolean validateUser(Integer id, String name) {
        if (id == null || name == null) {
            return false;
        }
        if (id <= 0) {
            return false;
        }
        if (name.isEmpty()) {
            return false;
        }
        return true;
    }

    public int calculateScore(int... scores) {
        if (scores == null || scores.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
}
