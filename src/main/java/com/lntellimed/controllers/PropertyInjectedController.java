package com.lntellimed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lntellimed.services.GreetingServiceImpl;

@Controller
public class PropertyInjectedController {

    @Autowired
    public GreetingServiceImpl greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

}
