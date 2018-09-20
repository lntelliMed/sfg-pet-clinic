package com.lntellimed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lntellimed.services.GreetingService;
import com.lntellimed.services.GreetingServiceImpl;

@Controller
public class GetterInjectedController {
    private GreetingService greetingService;

    public String sayHello(){
        return greetingService.sayGreeting();
    }

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
