package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@ToString
@Component
public class Person {
  private String userName;
  private Boolean boss;
  private Date birth;
  private Integer age;
}
