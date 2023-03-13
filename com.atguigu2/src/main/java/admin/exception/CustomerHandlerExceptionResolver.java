package admin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 自定义异常解析器
@Order(value = Ordered.HIGHEST_PRECEDENCE) // 最高优先级的，数字越小优先级越高
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(HttpServletRequest request,
                                       HttpServletResponse response,
                                       Object handler, Exception ex) {
    try {
      response.sendError(511, "我喜欢的错误");  // 也会被5xx解析
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ModelAndView();
  }
}
