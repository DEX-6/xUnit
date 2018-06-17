package ru.st.qa.jUnitTests.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by i-ru on 17.06.2018.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    public enum Type{
        RESOURCE,
        FILE
    }

    String value();
    Type type();
}
