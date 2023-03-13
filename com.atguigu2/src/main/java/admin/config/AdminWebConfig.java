package admin.config;

import admin.interceptor.LoginInterceptior;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class AdminWebConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginInterceptior()) // 实现过滤器的类
        .addPathPatterns("/**")  // 拦截
        .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**"
            ,"/js/**"); // 放行
  }
}
