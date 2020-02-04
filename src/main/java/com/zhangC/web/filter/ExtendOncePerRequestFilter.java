package com.zhangC.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangc on 2019/10/4.
 */
public class ExtendOncePerRequestFilter extends OncePerRequestFilter {


	@Override
	protected void initFilterBean() throws ServletException {
		System.out.println("Filter初始化...");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

		//设置跨域访问
		System.out.println("跨域。。。。。。。。。。。。。。。。。。。");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		filterChain.doFilter(httpServletRequest,httpServletResponse);
	}
}
