package ru.st.qa.jUnitTests.drafts.tests;

import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;
import ru.st.qa.jUnitTests.drafts.categories.Unstable;
import ru.st.qa.jUnitTests.drafts.rules.RestartUnstableTests;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1_WithRestartableResource {

    private static int attempt = 1;


    @Rule
    public TestRule restartUnstableTests = new RestartUnstableTests();


    @Test
    @Unstable(countOfRetry = 5)
    public void randomlyFailingTest_1() {
//        System.out.println("Test 1 is running");
        if (attempt == 5) {
            attempt = 1;

        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }

    @Test
    public void randomlyFailingTest_2() {
        System.out.println("Test 2 is running");
        if (attempt == 2) {
            attempt = 1;

        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }
}
