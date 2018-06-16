package ru.st.qa.jUnitTests.drafts.categories;

import java.lang.annotation.*;

/**
 * Аннотация, которой помечаются нестабильные тесты.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Unstable {
    /**
     * Поле, в котором необходимо указать количество перезапусков нестабильного теста
     */
    int countOfRetry();
}
