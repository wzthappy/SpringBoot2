package com.happy.springboot.c2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/test")
  public String test () {
    return "happy_ok";
  }

}
