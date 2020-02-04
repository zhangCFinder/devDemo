package com.zhangC.web.filter;

import com.zhangC.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by zhangc on 2019/9/27.
 */
public class WebContextListener implements ServletContextListener {

	@Autowired
	private IndexService indexService;

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		// 这里可以放你要执行的代码或方法
		System.out.println("contextInitialized");
		indexService.testListener();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");
	}
}
