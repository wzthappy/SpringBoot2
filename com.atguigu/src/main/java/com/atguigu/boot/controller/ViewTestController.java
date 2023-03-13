package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

  @GetMapping("/atguigu")
  public String atgugiu(Model model) {
    // model 中的数据会被放在请求域中
    model.addAttribute("msg", "你好 guigu");
    model.addAttribute("link", "http://www.baidu.com");
    // 跳转页面
    return "success";
  }
}
