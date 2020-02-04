package com.zhangC.aop.execution;

import com.zhangC.aop.customAnnotations.customAnnoLog;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by zhangc on 2019/9/19.
 */
@Service
@Scope(ConfigurableListableBeanFactory.SCOPE_SINGLETON)
public class IfaceImpl implements Iface {

	@Override
	public String say() {
		System.out.println("hello Code");
		return "returnCode";
	}

	@Override
	@customAnnoLog(type = "WARNING")
	public String saybyCoustomAnno() {
		System.out.println("saybyCoustomAnno");
		return "returnCode";
	}

	@Override
	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}
}
