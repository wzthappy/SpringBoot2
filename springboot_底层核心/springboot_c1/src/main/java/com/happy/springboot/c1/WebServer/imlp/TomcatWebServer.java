package com.happy.springboot.c1.WebServer.imlp;

import com.happy.springboot.c1.WebServer.WebServer;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class TomcatWebServer implements WebServer {

  @Override
  public void start(WebApplicationContext applicationContext) {
    System.out.println("启动Tomcat");
    startTomcat(applicationContext);
  }

  private static void startTomcat(WebApplicationContext applicationContext) {
    Tomcat tomcat = new Tomcat();

    Server server = tomcat.getServer();
    Service service = server.findService("Tomcat");

    Connector connector = new Connector();
    connector.setPort(8081);

    StandardEngine engine = new StandardEngine();
    engine.setDefaultHost("localhost");

    Host host = new StandardHost();
    host.setName("localhost");

    String contextPath = "";
    Context context = new StandardContext();

    context.setPath(contextPath);
    context.addLifecycleListener(new Tomcat.FixContextListener());

    host.addChild(context);
    engine.addChild(host);

    service.setContainer(engine);
    service.addConnector(connector);

    tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(applicationContext));
    context.addServletMappingDecoded("/*", "dispatcher");

    try {
      tomcat.start();
    } catch (LifecycleException e) {
      e.printStackTrace();
    }
  }
}
