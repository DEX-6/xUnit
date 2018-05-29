package ru.st.qa.testsNg.drafts;

import org.testng.annotations.*;

public class Test_1 {

    @Test
    public void test_1(){
        System.out.println("test_1 method");
    }

    @Test
    public void test_2(){
        System.out.println("test_2 method");
    }

    @BeforeSuite
    public void beforeSuitFixture(){
        System.out.println("before suit fixture");
    }
    @AfterSuite

    public void afterSuitFixture(){
        System.out.println("after suit fixture");
    }

    @BeforeTest
    public void beforeTestFixture(){
        System.out.println("before test fixture");
    }
    @AfterTest
    public void afterTestFixture(){
        System.out.println("after test fixture");
    }

    @BeforeClass
    public void beforeClassFixture(){
        System.out.println("before class fixture");
    }
    @AfterClass
    public void afterClassFixture(){
        System.out.println("after class fixture");
    }

    @BeforeMethod
    public void beforeMethodFixture(){
        System.out.println("before method fixture");
    }
    @AfterMethod
    public void afterMethodFixture(){
        System.out.println("after method fixture");
    }










}
