package com.zhangC.aop.execution;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by zhangc on 2019/9/19.
 */
@Aspect
@Component
public class LoggerAspect {
	@Around("execution(* com.zhangC.aop.execution.IfaceImpl.say(..))")
	public void aspectAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("方法调用前");
		joinPoint.proceed();
		System.out.println("方法调用后");
	}


	@Before("execution(* com.zhangC.aop.execution.IfaceImpl.say(..))")
	public void aspectBefore() throws Throwable{
		System.out.println("方法调用前");
	}

	@After("execution(* com.zhangC.aop.execution.IfaceImpl.say(..))")
	public void aspectAfter() throws Throwable{
		System.out.println("方法调用前");
	}

	@AfterReturning(pointcut = "execution(* com.zhangC.aop.execution.IfaceImpl.say(..))",returning = "retVal") //切点方法返回值完成后执行@AfterReturning
	public void aspectAfterReturning(Object retVal) throws Throwable{
		System.out.println("Returning:" + retVal.toString());
	}

	@AfterThrowing(pointcut = "execution(* com.zhangC.aop.execution.IfaceImpl.say(..))",throwing = "ex") //切点方法抛出异常之后执行@AfterThrowing
	public void aspectAfterThrowing(IllegalArgumentException ex) throws Throwable{
		System.out.println("There has been an exception: " + ex.toString());
	}
}
