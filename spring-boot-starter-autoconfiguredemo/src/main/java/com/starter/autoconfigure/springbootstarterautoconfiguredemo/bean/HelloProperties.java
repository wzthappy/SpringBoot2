package com.starter.autoconfigure.springbootstarterautoconfiguredemo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

@ConfigurationProperties("atguigu.hello")
public class HelloProperties {

  private String prefix;
  private String suffix;

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }
}
