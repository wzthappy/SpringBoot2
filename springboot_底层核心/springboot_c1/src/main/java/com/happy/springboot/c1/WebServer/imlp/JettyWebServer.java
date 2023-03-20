package com.happy.springboot.c1.WebServer.imlp;

import com.happy.springboot.c1.WebServer.WebServer;
import org.springframework.web.context.WebApplicationContext;

public class JettyWebServer implements WebServer {

  @Override
  public void start(WebApplicationContext applicationContext) {
    System.out.println("启动Jetty");
  }

}
