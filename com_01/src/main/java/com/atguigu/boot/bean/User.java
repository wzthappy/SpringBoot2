package com.atguigu.boot.bean;

import lombok.*;

// 用户
@Data // 他会自动在编译时生成对应的get和set方法
@ToString // 他会自动在编译时生成对应的toString方法
@AllArgsConstructor // 他会自动在编译时生成对应的全参构造器
@NoArgsConstructor // 他会自动在编译时生成对应的无参构造器
@EqualsAndHashCode // 它会生成equals(Object other) 和 hashCode()方法。
public class User {
  private String name;
  private Integer age;

  private Pet pet;

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
}
