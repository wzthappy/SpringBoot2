package com.starter.springbootstartertext.controller;

import com.starter.autoconfigure.springbootstarterautoconfiguredemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private HelloService helloService;

  @GetMapping("/")
  public String sayHello () {
    String s = helloService.sayHello("张三");
    return s;
  }
}
