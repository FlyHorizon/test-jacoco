package com.study.springbootmybatis.controller;

import com.study.springbootmybatis.client.UserClient;
import com.study.springbootmybatis.model.po.UserInfoCom;
import com.study.springbootmybatis.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1")
public class UserV1Controller {


    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String getHello() {
        System.out.println("one");
        return "v1 hello";
    }
    @RequestMapping(path = "/helloTwo", method = RequestMethod.GET)
    public String getTwo() {
        System.out.println("two");
        return "v2 hello two";
    }

    @RequestMapping(path = "/helloThree", method = RequestMethod.GET)
    public String getThree() {
        System.out.println("three");
        return "v2 hello three";
    }

    @RequestMapping(path = "/helloFour", method = RequestMethod.GET)
    public String getFour() {
        System.out.println("four");
        return "v4 hello four";
    }

    @RequestMapping(path = "/helloFive", method = RequestMethod.GET)
    public String getFive() {
        System.out.println("FIve");
        return "v2 hello Five";
    }

    @RequestMapping(path = "/helloSex", method = RequestMethod.GET)
    public String getSex() {
        System.out.println("Sex");
        return "v4 hello Sex";
    }

    @RequestMapping(path = "/helloSeven", method = RequestMethod.GET)
    public String getSeven() {
        System.out.println("Seven");
        return "v4 hello Seven";
    }
}
