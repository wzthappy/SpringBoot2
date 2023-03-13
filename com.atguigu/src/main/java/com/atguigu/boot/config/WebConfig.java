package com.atguigu.boot.config;

import com.atguigu.boot.converter.GuiguMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class WebConfig {

  @Bean
  public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
    HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
    methodFilter.setMethodParam("_m");  // 把 _method 更改为 _m
    return methodFilter;
  }

  // 1. WebMvcConfigurer定制化SpringMVC功能的
  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    return new WebMvcConfigurer() {

      @Override  // 添加自定义的converter
      public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new GuiguMessageConverter());
      }

      @Override // 自定义内容协商策略
      public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypes = new HashMap<>();
        // 适配请求行的  format = ?
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("gg", MediaType.parseMediaType("application/x-guigu"));
        // 指定支持解析那些参数对应的那些媒体类型
        ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypes);

        // 要添加适配请求头的  application/?
        HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

        configurer.strategies(Arrays.asList(parameterStrategy, headerStrategy));
      }
    };
  }

}
