package com.springapp.mvc.interceptor;

import com.springapp.mvc.annotation.AccessRequired;
import com.springapp.mvc.exception.AppException;
import com.springapp.mvc.exception.ResultResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截url中的access_token
 * @author Nob
 *
 */
public class UserAccessApiInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        AccessRequired annotation = method.getAnnotation(AccessRequired.class);
        if (annotation != null) {
            String accessToken = request.getParameter("access_token");
            System.out.println(request.getSession().getId());
            if (accessToken != null) {
                return true;
            } else {
                // 没有注解通过拦截
                throw new AppException(-200,"用户未登录");
            }
        }
        return true;

    }
}
