package com.zhangC.aop.customAnnotations;

import java.lang.annotation.*;

/**
 * Created by zhangc on 2019/9/23.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface customAnnoLog {
	String type() default "";
}
