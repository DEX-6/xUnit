package ru.st.qa.jUnitTests.drafts.suits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.st.qa.jUnitTests.drafts.tests.Test1;
import ru.st.qa.jUnitTests.drafts.tests.Test2;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test1.class,
        Test2.class
})
public class MySuit {
}
