package admin.controller;

import admin.bean.City;
import admin.bean.SysConfig;
import admin.bean.User;
import admin.service.AccountService;
import admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  AccountService accountService;

  @Autowired
  CityService cityService;

  @PostMapping("/city")
  @ResponseBody
  public City saveCity (City city) {
    cityService.saveCity(city);
    return city;
  }

  @ResponseBody
  @GetMapping("/city")
  public City getCityById(@RequestParam("id") Long id) {
    return cityService.getById(id);
  }

  @GetMapping("/sys")
  @ResponseBody
  public SysConfig getById(@RequestParam("id") String id) {
    return accountService.getSysById(id);
  }

  @ResponseBody
  @GetMapping("/sql")
  public String queryFromDb() {
    Long aLong = jdbcTemplate.queryForObject("select count(*) from sys_config", Long.class);
    return aLong.toString();
  }

  // 来登录页
  @GetMapping(value = {"/", "/login"})
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String main (User user, HttpSession session, Model model) {
    // 账号和密码不为空就登录成功
    if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {
      // 把登录成功的用户保存起来
      session.setAttribute("loginUser", user);

      // 登录成功重定向到main.html，重定向防止表单重复提交
      return "redirect:/main.html";
    }

    model.addAttribute("msg", "账号密码错误");
    // 登录失败，回到登录页面
    return "login";
  }

  // 去main页面
  @GetMapping("/main.html")
  public String mainPage(HttpSession session, Model model) {
    // 是否登录成功.  拦截器，过滤器
    Object loginUser = session.getAttribute("loginUser");
    if (loginUser != null) {
      // 登录成功
      return "main";
    }
    // 登录失败
    model.addAttribute("msg", "请重新登录");
    return "login";
  }
}
