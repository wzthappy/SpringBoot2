package com.show.admin.bean;

import jdk.jfr.Period;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Data
@Profile("prod")
@Controller
@ConfigurationProperties("person")
public class Boss implements Person {
  private String name;
  private Integer age;
}
