package ru.st.qa.jUnitTests.tests.unstableTests;

import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.runners.MethodSorters;
import ru.st.qa.jUnitTests.annotations.Unstable;
import ru.st.qa.jUnitTests.rules.RestartUnstableTests;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UnstableTest {

    private static int attempt = 1;


    @Rule
    public TestRule restartUnstableTests = new RestartUnstableTests();

    /*
     * Тест запускается, т. к. согласно правилу имеет аннотацию @Unstable
     * */
    @Test
    @Unstable(countOfRetry = 5)
    public void randomlyFailingTest_1() {
        System.out.println("Test 1 is running");
        if (attempt == 5) {
            attempt = 1;
            System.out.println("Success!");
        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }

    /*
     * Тест не запускается, т. к. не имеет аннотации @Unstable
     * */
    @Test
    public void randomlyFailingTest_2() {
        System.out.println("Test 2 is running");
        if (attempt == 2) {
            attempt = 1;
            System.out.println("Success!");
        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }
}
