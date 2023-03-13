package com.show.admin.bean;

import org.springframework.stereotype.Controller;

@Controller
public interface Person {
  String getName();
  Integer getAge();
}
