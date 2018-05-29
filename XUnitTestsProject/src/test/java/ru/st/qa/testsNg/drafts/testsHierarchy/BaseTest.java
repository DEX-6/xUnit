package ru.st.qa.testsNg.drafts.testsHierarchy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class BaseTest {

    @Test
    public void baseTestMethod() {
        System.out.println("base test method");
    }

    @BeforeTest
    public void beforeBaseTestFixture() {
        System.out.println("before base test fixture");
    }

    @BeforeClass
    public void beforeBaseClassFixture() {
        System.out.println("before base class fixture");
    }

    @BeforeMethod
    public void beforeBaseMethodFixture(){
        System.out.println("before base method fixture");
    }
}
