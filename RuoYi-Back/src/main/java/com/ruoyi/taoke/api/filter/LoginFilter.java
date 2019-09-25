package com.com.ruoyi.taoke.api.filter;

//判断是否登陆的 filter

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//@WebFilter(filterName = "webFilter",urlPatterns = "/web/*")
//public class LoginFilter implements Filter {
//
//
//    //初始化调用的方法
//    //当服务器 被启动的时候，调用
//    public void init(FilterConfig filterConfig) throws ServletException { }
//
//    //拦截的方法
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        //解决跨域的问题
//        response.setHeader("Access-Control-Allow-Origin","http://localhost:10086");
//        response.setHeader("Access-Control-Allow-Credentials","true");
//        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With,X-App-Id, X-Token");
//        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        filterChain.doFilter(request,response);
//    }
//
//    //销毁时候调用的方法
//    public void destroy() { }
//}