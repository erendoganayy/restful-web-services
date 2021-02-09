package com.restful.rest.webservices.restfulwebservices.helloworld;
//Controller

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    //GET
    //URI - /hello-word
    //method - "Hello"
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!!";

    }
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Dünyam!");

    }
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));

    }
}
