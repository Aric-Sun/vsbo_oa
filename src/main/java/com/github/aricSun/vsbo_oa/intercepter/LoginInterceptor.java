package com.github.aricSun.vsbo_oa.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在目标方法执行前会执行这个拦截器
 * 拦截川户的所有的请求，判断当前访间有没有进行登录操作。、
 * 如果登录了，则放行，- 返回true
 * 如果没有登录的话，则阻止这次请求，返回false, 并且让这个请求来到登陆页面
 * @author AricSun
 * @date 2021.01.08 10:33
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /*
     * function: 请求前调用
     * @Param [httpServletRequest, httpServletResponse, o]
     * @Return boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 100% 放行的页面：login.jsp
        String uri = request.getRequestURI();

        //判断uri中是否创含装个字符 index, login
        if (uri.contains("login") || uri.contains("index")){
            return true;
        }

        // 如果用户已经登录，放行
        if (request.getSession().getAttribute("emp") != null){
            return true;
        }

        // 如果上面都没有放行，则将该请求查定向到登录页
        response.sendRedirect("login.jsp");
        return false;  // 返回false，请求中断
    }

    /*
     * function:请求后调用
     * @Param [httpServletRequest, httpServletResponse, o, modelAndView]
     * @Return void
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /*
     * function: 请求调用完成后回调方法，即在视图渲染完成后回调
     * @Param [httpServletRequest, httpServletResponse, o, e]
     * @Return void
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
