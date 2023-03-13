package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // 他会自动在编译时生成对应的get和set方法
@ToString // 他会自动在编译时生成对应的toString方法
@AllArgsConstructor // 他会自动在编译时生成对应的全参构造器
@NoArgsConstructor // 他会自动在编译时生成对应的无参构造器
public class Pet {
  private String name;
}
