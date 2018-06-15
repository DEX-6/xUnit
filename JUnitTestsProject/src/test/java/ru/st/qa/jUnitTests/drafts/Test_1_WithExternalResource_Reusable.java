package ru.st.qa.jUnitTests.drafts;

import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runners.MethodSorters;

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
    public void aTestMethod2() {
        System.out.println(className + " test method 2");
    }


}
