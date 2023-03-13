package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;

// 主程序类: 主配置类
// 这个一个SpringBoot应用
@SpringBootApplication
public class MainApplication {
  public static void main(String[] args) {
    // 1. 返回我们IOC容器
    ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

    // 2. 查看容器里面的组件
    String[] names = run.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(name);
    }
    String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
    System.out.println(" ================ 有 " + beanNamesForType1.length + "个WebMvcProperties类型的数据");

    String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
    System.out.println(" ================ 有 " + beanNamesForType.length + "个CacheAspectSupport类型的数据");

    // 3. 从容器中获取组件
//    Pet tom01 = run.getBean("tom", Pet.class);  // (id, 类.class)
//    Pet tom02 = run.getBean("tom", Pet.class);
//
//    System.out.println("组件: " + (tom01 == tom02));
//
//    System.out.println("======================");
//    MyConfig bean = run.getBean(MyConfig.class); // 配置类
//    System.out.println(bean); // com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$dd22175e@2e179f3e
//    System.out.println("====================");
//    User user = bean.user01();
//    User user1 = bean.user01();
//    System.out.println(user == user1);
//
//    User user01 = run.getBean("user01", User.class);
//    Pet tom = run.getBean("tom", Pet.class);
//
//    System.out.println("-----------------");
//    System.out.println("用户的宠物: " + (user01.getPet() == tom));
//
//    System.out.println("+++++++++++++++++");
//    // 5. 获取组件
//    String[] beanNamesForType = run.getBeanNamesForType(User.class);
//    for (String s : beanNamesForType) {
//      System.out.println(s);
//    }
//
//    DBHelper bean1 = run.getBean(DBHelper.class);
//    System.out.println(bean1);

    // 判断容器中是否有这个组件
    boolean tom = run.containsBean("tom");
    System.out.println("容器中Tom组件: " + tom);

    boolean user01 = run.containsBean("user01");
    System.out.println("容器中user01组件: " + user01);

    boolean tom22 = run.containsBean("tom22");
    System.out.println("容器中Tom22组件: " + tom22);


    boolean haha = run.containsBean("haha");
    boolean hehe = run.containsBean("hehe");
    System.out.println("容器中haha组件: " + haha);
    System.out.println("容器中hehe组件: " + hehe);


  }
}
