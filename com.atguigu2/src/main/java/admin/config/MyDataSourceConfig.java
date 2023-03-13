//package admin.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.Arrays;
//
//@Configuration
//public class MyDataSourceConfig {
//
//  @Bean
//  @ConfigurationProperties("spring.datasource")
//  public DataSource dataSource () throws SQLException {
//    DruidDataSource druidDataSource = new DruidDataSource();
//
////    druidDataSource.setUrl();
////    druidDataSource.setUsername();
////    druidDataSource.setPassword();
//    druidDataSource.setFilters("stat,wall");
//
//
//    return druidDataSource;
//  }
//
//  // 配置druid监控页功能
//  @Bean
//  public ServletRegistrationBean servletRegistrationBean () {
//    StatViewServlet statViewServlet = new StatViewServlet();
//    ServletRegistrationBean servletRegistrationBean =
//        new ServletRegistrationBean(statViewServlet, "/druid/*");
//
//    servletRegistrationBean.addInitParameter("loginUsername", "admin");
//    servletRegistrationBean.addInitParameter("loginPassword", "123456");
//
//    return servletRegistrationBean;
//  }
//
//  // WebStatFilter用于采集web-jdbc关联监控的数据
//  @Bean
//  public FilterRegistrationBean filterRegistrationBean () {
//    WebStatFilter webStatFilter = new WebStatFilter();
//    FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
//    webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//    webStatFilterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//
//    return webStatFilterFilterRegistrationBean;
//  }
//}
