package com.atguigu.boot.controller;


import com.atguigu.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestComtroller {

  /**
   * 1. 浏览器发请求直接返回xml
   * 2. 如果时ajax请求 返回json
   * 3. 如果时尚硅谷发送请求 返回自定义的
   *
   * 步骤:
   *  1. 添加自定义的MessageConverter进系统底层
   *  2. 系统底层就会统计出所有MessageConverter能操作哪些类型
   *  3. 客户端内容协商
   * @returnn
   */
  @ResponseBody
  @GetMapping("/test/person")
  public Person getPerson() {
    Person person = new Person();
    person.setAge(23);
    person.setBirth(new Date());
    person.setBoss(true);
    person.setUserName("开开");
    return person;
  }

  @GetMapping("/goto")
  public String goToPage(HttpServletRequest request) {
    request.setAttribute("msg", "成功了.....");
    request.setAttribute("code", 200);
    return "forward:/success"; // 转发到  /success请求
  }

  @GetMapping("/params")
  public String testParam (Map<String, Object> map,
                           Model model,
                           HttpServletRequest request,
                           HttpServletResponse response) {
    map.put("hello", "world6666");
    model.addAttribute("world", "hello666");
    request.setAttribute("message", "HelloWorld");
    Cookie cookie = new Cookie("c1", "v1");
    response.addCookie(cookie);
    return "forward:/success";
  }

  @ResponseBody
  @GetMapping("/success")
  public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                        @RequestAttribute(value = "code", required = false) Integer code,
                        HttpServletRequest request) {
    Object msg1 = request.getAttribute("msg");

    Map<String, Object> map = new HashMap<>();
    map.put("reqMethod_msg", msg1);
    map.put("annotation_msg", msg);
    String hello = (String) request.getAttribute("hello");
    String world = (String) request.getAttribute("world");
    String message = (String) request.getAttribute("message");
    map.put("hello", hello);
    map.put("world", world);
    map.put("message", message);
    return map;
  }
}
