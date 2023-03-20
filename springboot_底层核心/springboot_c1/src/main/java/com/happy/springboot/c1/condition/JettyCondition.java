package com.happy.springboot.c1.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class JettyCondition implements Condition {
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
      try {
      context.getClassLoader().loadClass("org.eclipse.jetty.server.Server");
      return true;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }
}
