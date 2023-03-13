package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class HelloController {

  @Autowired // 注入的方式
  private Car car;

  @RequestMapping("/car")
  public Car car () {
    return car;
  }

  @RequestMapping("/hello")
  public String hand1e01(@RequestParam String name) {
//    log.info("请求进来了....");
    return "Hello，Spring Boot 2 " + "你好" + name + "111";
  }
}
