package com.show.admin.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Data
@Profile("test")
@Controller
@ConfigurationProperties("person")
public class Worker implements Person {
  private String name;
  private Integer age;
}
