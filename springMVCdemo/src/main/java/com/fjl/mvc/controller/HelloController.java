package com.fjl.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String index(){
//        return "hello";
//    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("sayhaha","haha");
        return "success";
    }
}
