package com.lntellimed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lntellimed.services.GreetingService;
import com.lntellimed.services.GreetingServiceImpl;

@Controller
public class ConstructorInjectedController {

    private GreetingService greetingService;

    @Autowired
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
