package com.happy.springboot.c1;

import com.happy.springboot.c1.WebServer.WebServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

public class HappySpringApplication {

  public static void run (Class clazz) {

    // 创建一个Spring日容器   配置Spring
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.register(clazz);
    applicationContext.refresh();

    // 接收到一个HTTP请求 ---> 处理请求(Servlet)  启动Tomcat
    WebServer webServer = getWebServer(applicationContext);
    webServer.start(applicationContext);
  }

  private static WebServer getWebServer(WebApplicationContext applicationContext) {
    // key为beanName, value为Bean对象
    Map<String, WebServer> webServers = applicationContext.getBeansOfType(WebServer.class);

    if (webServers.isEmpty()) {
      throw new NullPointerException();
    }

    if (webServers.size() > 1) {
      throw new IllegalStateException();
    }

    // 返回唯一的一个
    return webServers.values().stream().findFirst().get();
  }
}
