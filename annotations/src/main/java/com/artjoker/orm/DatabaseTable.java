package com.artjoker.orm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Documented
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.SOURCE)
public @interface DatabaseTable {
    String name() default "";
}
