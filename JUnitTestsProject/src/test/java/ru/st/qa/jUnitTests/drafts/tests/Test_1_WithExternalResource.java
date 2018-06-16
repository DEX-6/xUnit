package ru.st.qa.jUnitTests.drafts.tests;

import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1_WithExternalResource {

    private String className = Test_1_WithExternalResource.class.getSimpleName();

    @Rule
    public final ExternalResource externalResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("-------------------------------");
            System.out.println(className + " test1 setUp");
        }

        @Override
        protected void after() {
            System.out.println(className + " test1 tear down");
        }
    };

    @Test
    public void bTestMethod1() {
        System.out.println(className + " test method 1");
    }

    @Test
    public void aTestMethod2() {
        System.out.println(className + " test method 2");
    }
}
