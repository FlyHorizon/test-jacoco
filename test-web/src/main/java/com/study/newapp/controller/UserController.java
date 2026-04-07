package com.study.newapp.controller;

import com.study.newapp.client.UserClient;
import com.study.newapp.model.pojo.UserInfoCom;
import com.study.newapp.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v2")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserClient userClient;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public UserInfoCom getUserInfo(@PathVariable("id") Integer id){
        return userService.getUserInfo(id);
    }

    @RequestMapping(path = "/turn/{id}", method = RequestMethod.GET)
    public UserInfoCom getUserInfoByFeign(@PathVariable("id") Integer id) {
        System.out.println("hello");
        System.out.println("turn/id");

        return userService.getUserInfo(id);
    }

    @RequestMapping(path = "/commit/one/{id}", method = RequestMethod.GET)
    public UserInfoCom getUserInfoByFeignCommitOne(@PathVariable("id") Integer id) {
        System.out.println("commitOne");
        System.out.println(userClient.getClass().getName());
        if (id==1){
            System.out.println("1");
        }else{
            System.out.println("2");
        }
        return userClient.getUser(id);
    }

    @RequestMapping(path = "/commit/two/{id}", method = RequestMethod.GET)
    public UserInfoCom getUserInfoByFeignCommitTwo(@PathVariable("id") Integer id) {
        System.out.println("commitTwo");
        if (id==1 || id==2){
            System.out.println("12");
        }else{
            System.out.println(userClient.getClass().getName());
            System.out.println("1");
        }
        return userClient.getUser(id);
    }

    @RequestMapping(path = "/name/{id}", method = RequestMethod.GET)
    public String getUserName(@PathVariable("id") Integer id) {
        System.out.println("getUserName");
        return userService.getUserName(id);
    }

    @RequestMapping(path = "/validate", method = RequestMethod.POST)
    public boolean validateUser(Integer id, String name) {
        System.out.println("validateUser");
        return userService.validateUser(id, name);
    }

    @RequestMapping(path = "/score", method = RequestMethod.GET)
    public int calculateScore(Integer s1, Integer s2, Integer s3) {
        System.out.println("calculateScore");
        return userService.calculateScore(s1, s2, s3);
    }
}
