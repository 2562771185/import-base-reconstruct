package com.tjhq.wsjrj.mjz.importbase.annotation;

import java.lang.annotation.*;

/**
 * 日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    //模块名
    String module() default "";
	//操作名
    String operation() default "";
}