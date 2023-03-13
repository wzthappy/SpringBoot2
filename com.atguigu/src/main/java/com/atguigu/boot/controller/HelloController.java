package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/a")
public class HelloController {

  @RequestMapping("/a1.mp4")
  public String hello() {
    return "23123";
  }

  //  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @GetMapping("/user")
  public String getUser() {
    return "GET-张三";
  }

  //  @RequestMapping(value = "/user", method = RequestMethod.POST)
  @PostMapping("/user")
  public String saveUser() {
    return "POST-张三";
  }

  //  @RequestMapping(value = "/user", method = RequestMethod.PUT)
  @PutMapping("/user")
  public String putUser() {
    return "PUT-张三";
  }

  //  @RequestMapping(value = "/user", method = RequestMethod.DELETE)
  @DeleteMapping("/user")
  public String deleteUser() {
    return "DELETE-张三";
  }
}
