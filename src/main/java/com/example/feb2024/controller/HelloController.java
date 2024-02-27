package com.example.feb2024.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/greet")
    public String sayHello(){
        return "WELCOME TO SPRINGBOOT FRAMEWORK";
    }

    @GetMapping("/greet/{firstName}")
    public String sayHello(@PathVariable("firstName") String inputValue){
        return "HI "+inputValue+", WELCOME TO SPRINGBOOT FRAMEWORK";
    }

    @GetMapping("/greet/{firstName}/{lastName}")
    public String sayHello(@PathVariable("firstName") String firstName,
                           @PathVariable("lastName") String lastName){
        return "HI "+firstName.toUpperCase()+" "+lastName.toUpperCase()+", WELCOME TO SPRINGBOOT FRAMEWORK";
    }

    @GetMapping("/greetwithparams")
    public String sayHelloWitParams(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName){
        return "HI "+firstName.toUpperCase()+" "+lastName.toUpperCase()+", WELCOME TO SPRINGBOOT FRAMEWORK";
    }

}

//IOC - Inversion of Control
// @RestController @Controller @Service @Repository @Component @Bean
