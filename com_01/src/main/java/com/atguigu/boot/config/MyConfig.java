//package com.atguigu.boot.config;
//
//import ch.qos.logback.core.db.DBHelper;
//import com.atguigu.boot.bean.Car;
//import com.atguigu.boot.bean.Pet;
//import com.atguigu.boot.bean.User;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.ImportResource;
//
///**
// * 1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
// * 2. 配置类本身也是组件
// * 3. proxyBeanMethods： 代理bean的方法
// *              false  每次调用都是不同的实例
// *              true  每次调用都是(第一个创建的对象)同一个对象(保持组件单实例)，默认的
// * 4. @Import({User.class, DBHelper.class})
// *          给容器中自动创建出这两个类型的组件 ，默认组件的名字是全类名
// */
//@Import({User.class, DBHelper.class})
//@Configuration(proxyBeanMethods = true) // 告诉springBoot这是一个配置类  等价于  配置文件
////@ConditionalOnBean(name = "tom") // 表示只有容器中有tom这个组件时，才会执行他下面的方法或类
//@ImportResource("classpath:beans.xml")
//@EnableConfigurationProperties(Car.class) // 1. 开启Car属性配置功能  2. 把这个Car这个组件自动注入到组件中
//public class MyConfig {
//
//  /**
//   * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
//   */
//  @Bean // 给容器中添加组件。以方法名作为组件id，返回类型就是组件类型。放回的值，就是组件在容器中的实例
//  public User user01 () {
//    User z = new User("张三", 18);
//    // user组件依赖单实例
//    z.setPet(tomcatPet());
//    return z;
//  }
//
//  @Bean("tom22") // 自定义id名
//  public Pet tomcatPet () {
//    return new Pet("tomcat");
//  }
//}
