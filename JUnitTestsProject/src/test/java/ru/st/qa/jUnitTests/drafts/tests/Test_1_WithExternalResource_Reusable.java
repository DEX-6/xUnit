package ru.st.qa.jUnitTests.drafts.tests;

import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runners.MethodSorters;
import ru.st.qa.jUnitTests.annotations.Unstable;
import ru.st.qa.jUnitTests.drafts.rules.ReusableRule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1_WithExternalResource_Reusable {
    // TODO: 15.06.2018 Не доделано
    private static String className = Test_1_WithExternalResource_Reusable.class.getSimpleName();

    @ClassRule
    public static ExternalResource externalResource = new ReusableRule();

    @Test
    public void bTestMethod1() {
        System.out.println(className + " test method 1");
    }

    @Test
    @Unstable(countOfRetry = 3)
    public void aTestMethod2() {
        System.out.println(className + " test method 2");
    }


}
