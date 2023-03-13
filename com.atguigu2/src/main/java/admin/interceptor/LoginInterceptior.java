package admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 登录检查
 *   1. 配置好拦截器要拦截那些请求
 *   2. 把这些配置放在容器中
 */
@Slf4j
public class LoginInterceptior implements HandlerInterceptor {
  @Override  // 目标方法执行前
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    StringBuffer requestURL = request.getRequestURL();
    log.info("拦截请求路径是{}", requestURL);
    // 登录检查逻辑
    HttpSession session = request.getSession();

    Object loginUser = session.getAttribute("loginUser");

    if (loginUser != null) return true; // 放行

    // 拦截了。未登录，跳转到登录页
    request.setAttribute("msg", "请先登录");
//    response.sendRedirect("/");
    request.getRequestDispatcher("/").forward(request, response);
    return false; // 拦截
  }

  @Override  // 代码执行完成以后
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override  // 页面渲染以后
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
  }
}
