package com.show.admin.controller;

import com.show.admin.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private Person person;

  @GetMapping("/")
  private String hello() {
    return person.getName() + ", " + person.getAge();
  }

  @GetMapping("/person")
  private Person person() {
    return person;
  }
}
