package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
@Component
//@Data // 他会自动在编译时生成对应的get和set方法
@ToString // 他会自动在编译时生成对应的toString方法
// 他会在application.properties(核心配置文件)中，自动的查找以mycar开头的 后名的名字对应我们的变量名，如果
//    对应上了就把配置文件中对应的值赋予对应的变量
@ConfigurationProperties(prefix = "mycar")
public class Car {
  private String brand;
  private Integer price;

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
