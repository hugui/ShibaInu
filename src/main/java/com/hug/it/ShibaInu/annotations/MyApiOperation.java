package com.hug.it.ShibaInu.annotations;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyApiOperation {
    String value();

    String since();

    String author();
}
