package com.happy.springboot.c1.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TomcatCondition implements Condition {
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    // 判断有没有tomcat的依赖
    try {
      // 判断有没有这个类有没有进行加载    如果没有他则会报错
      context.getClassLoader().loadClass("org.apache.catalina.startup.Tomcat");
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
