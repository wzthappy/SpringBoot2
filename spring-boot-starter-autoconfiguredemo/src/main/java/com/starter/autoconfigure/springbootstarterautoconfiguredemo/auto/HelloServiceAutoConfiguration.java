package com.starter.autoconfigure.springbootstarterautoconfiguredemo.auto;

import com.starter.autoconfigure.springbootstarterautoconfiguredemo.bean.HelloProperties;
import com.starter.autoconfigure.springbootstarterautoconfiguredemo.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)  // 默认HelloProperties放在容器中
public class HelloServiceAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(HelloService.class)
  public HelloService helloService() {
    HelloService helloService = new HelloService();
    return helloService;
  }
}
