package com.hazer.gyo.hazer.springboot.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public  String hello(){
        return "Hello World";
    }





}