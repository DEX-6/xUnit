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
     * Тест перезапускается заданное количество раз, т. к. согласно правилу имеет аннотацию @Unstable
     * */
    @Test
    @Unstable(countOfRetry = 5)
    public void randomlyFailingTest_1() {
        System.out.println("Test 1 is running");
        if (attempt == 3) {
            attempt = 1;
            System.out.println("Success!");
        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }

    /*
     * Тест запускается в обычном режиме
     * */
    @Test
    public void stableTest() {
        System.out.println("Test 2 is running");
            System.out.println("Success!");
    }
}
