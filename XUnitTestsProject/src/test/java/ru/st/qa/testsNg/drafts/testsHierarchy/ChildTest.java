package ru.st.qa.testsNg.drafts.testsHierarchy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChildTest extends BaseTest {

    @Test
    public void childTestOneMethod(){
        System.out.println("child test 1 method");
    }

    @Test
    public void childTestTwoMethod(){
        System.out.println("child test 2 method");
    }

    @BeforeTest
    public void beforeChildTestFixture() {
        System.out.println("before child test fixture");
    }

    @BeforeClass
    public void beforeChildClassFixture(){
        System.out.println("before child class fixture");
    }

    @BeforeMethod
    public void beforeChildMethodFixture(){
        System.out.println("before child method fixture");
    }
}
