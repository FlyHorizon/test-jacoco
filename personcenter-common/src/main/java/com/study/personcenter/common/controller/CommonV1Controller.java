package com.study.personcenter.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共模块提供的 Controller，参照 UserV1Controller 的接口风格。
 * 不依赖数据库，直接吐字符串返回值，方便做覆盖率测试。
 */
@RestController
@RequestMapping("/api/common/v1")
public class CommonV1Controller {

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String getHello() {
        System.out.println("common one");
        return "v1 hello";
    }

    @RequestMapping(path = "/helloTwo", method = RequestMethod.GET)
    public String getTwo() {
        System.out.println("common two");
        return "v2 hello two";
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


}
