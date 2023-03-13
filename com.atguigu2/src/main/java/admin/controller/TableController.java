package admin.controller;

import admin.bean.User;
import admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TableController {

  @Autowired
  private UserService userService;

  @GetMapping("/basic_table")
  public String basic_table() {
    int i = 100 / 0; // 制造异常  500

    return "table/basic_table";
  }

  @GetMapping("/dynamic_table")
  @ResponseBody
  public Page<User> dynameic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn
      , Model model) {
    // 表格内容的遍历
//    List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//        new User("lisi", "123444"),
//        new User("hehe", "wqeqw"),
//        new User("haha", "wwwwww"));
//
//    model.addAttribute("users", users);
//
//    if (users.size() > 3) {
//      throw new UserTooManyException();
//    }

    // 从数据库中查出user表中的用户进行展示
    List<User> list = userService.list();
//    model.addAttribute("users", list);

    // 分页查询数据
    Page<User> userPage = new Page<>(pn, 2);// (当前页码，每页的数据)
    // 分页查询数据
    Page<User> page = userService.page(userPage, null);
    long total = page.getTotal();
    System.out.println(total);

    model.addAttribute("page", page);
//    return "table/dynamic_table";
    return page;
  }

  @GetMapping("/responsive_table")
  public String responsive_table(@RequestParam("name") String name) {

    return "table/responsive_table";
  }

  @GetMapping("/editable_table")
  public String editable_table() {

    return "table/editable_table";
  }

}
