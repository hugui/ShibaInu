package com.hug.it.ShibaInu.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyApi {
    String[] versions() default "";

    String name() default "自定义模块";
}
