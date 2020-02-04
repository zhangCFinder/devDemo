package com.zhangC.aop.customAnnotations;

/**
 * 功能：注解类的实现
 * Created by zhangc on 2019/9/23.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectImpl {

	@Pointcut("@annotation(com.zhangC.aop.customAnnotations.customAnnoLog)")
	private void cut() {
	}

// 开始环绕

	@Around("cut()")

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("AroundBefore");
		Object res = null;
		try {

			res = joinPoint.proceed();

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("AroundAfter");
		return res;

	}

	@Before("cut()")

	public void before() {

		System.out.println("before");

	}

	@After("cut()")

	public void after() {

		System.out.println("after");

	}


	@AfterReturning(returning = "returnValue", pointcut = "@annotation(log)")
	public void afterReturn(JoinPoint point, Object returnValue, customAnnoLog log) {
		System.out.println("afterReturn");
		System.out.println("returnValue---" + returnValue);
		// 注解中的类型
		String enumKey = log.type();
		System.out.println("enumKey---" + enumKey);
		System.out.println(Type.valueOf(enumKey).getOperation());

	}

}