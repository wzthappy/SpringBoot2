package admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 处理整个web  controller的异常
@ControllerAdvice
@Slf4j
public class GlobalExcepotionHandler {

  @ExceptionHandler({ArithmeticException.class, NullPointerException.class}) // 处理异常
  public String handleArithException(Exception e) {
    log.info("异常是: {}", e);
    return "login"; // 视图地址
  }
}
