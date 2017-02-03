package com.artjoker.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.SOURCE)
public @interface DatabaseField {
    String name() default "";

    boolean notNull() default false;

    boolean unique() default false;

    boolean primaryKey() default false;

    boolean autoincrement() default false;

    String defaultValue() default "";
}