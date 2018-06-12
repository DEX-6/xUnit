package ru.st.qa.jUnitTests.suits;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.st.qa.jUnitTests.categories.MyCategories;
import ru.st.qa.jUnitTests.tests.CreateNewFileTest;

/**
 * Created by i-ru on 12.06.2018.
 */

@Suite.SuiteClasses({
        CreateNewFileTest.class
})
@RunWith(Categories.class)
@Categories.IncludeCategory({MyCategories.PositiveTest.class})
public class PositiveTests {
}
