package com.zhangC.web.filter;

import com.zhangC.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by zhangc on 2019/9/28.
 */
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IndexService indexService;


	@Override
	public void init(ServletConfig config) {
		try {
			super.init();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		System.out.println("InitServlet");
		indexService.testListener();
//
//		System.out.println("================>[Servlet]自动加载启动开始.");
//		//读取Spring容器中的Bean[此时Bean已加载,可以使用]
//		//执行想要的代码
//		System.out.println("================>[Servlet]自动加载启动结束.");
	}
}
