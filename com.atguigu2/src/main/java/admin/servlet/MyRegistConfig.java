package admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {

  @Bean
  public ServletRegistrationBean myServlet() {
    MyServlet myServlet = new MyServlet();
    return new ServletRegistrationBean(myServlet, "/my", "/my02");
  }

  @Bean
  public FilterRegistrationBean myFilter() {
    MyFilter filter = new MyFilter();
//    return new FilterRegistrationBean(filter, myServlet());
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter);
    filterRegistrationBean.setUrlPatterns(Arrays.asList("/my", "/css/*"));
    return filterRegistrationBean;
  }

  @Bean
  public ServletListenerRegistrationBean myListener() {
    return new ServletListenerRegistrationBean(new MyServletContextListener());
  }
}
