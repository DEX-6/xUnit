package ru.st.qa.jUnitTests.drafts.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 {

    private String className = Test1.class.getSimpleName();

    @Before
    public void setUp(){
        System.out.println("-------------------------------");
        System.out.println(className + " test1 setUp");
    }

    @Test
    public void bTestMethod1(){
        System.out.println(className + " test method 1");
    }

    @Test
    public void aTestMethod2(){
        System.out.println(className + " test method 2");
    }

    @After
    public void tearDown(){
        System.out.println(className + " test1 tear down");
    }
}
