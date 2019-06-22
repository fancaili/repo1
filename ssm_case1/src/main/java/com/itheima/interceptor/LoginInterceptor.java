package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tanshuai on 2019/6/16.
 * 权限校验：用户必须登陆才能访问，不登陆默认让用户先去登陆然后访问
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获得session
        HttpSession session = request.getSession();
        //从session中获取用户信息
        Object user = session.getAttribute("user");
        if(user==null){
            //用户没有登陆 跳转登陆页面
            response.sendRedirect(request.getContextPath()+"/html/login.html");
            return false;
        }
        return true;
    }
}
