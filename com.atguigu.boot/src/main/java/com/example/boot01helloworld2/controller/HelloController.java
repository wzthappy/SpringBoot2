package com.example.boot01helloworld2.controller;

import com.example.boot01helloworld2.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private Person person;

  @RequestMapping("/person")
  public Person person() {
    return person;
  }
}
