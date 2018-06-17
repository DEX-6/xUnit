package ru.st.qa.jUnitTests.dataProviders;

import com.tngtech.java.junit.dataprovider.DataProvider;
import org.junit.runners.model.FrameworkMethod;
import ru.st.qa.jUnitTests.annotations.DataSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by i-ru on 17.06.2018.
 */
public class UniversalDataProviders {

    @DataProvider
    public static Object[][] dataSourceLoader(FrameworkMethod testMethod) throws IOException {
        DataSource ds = testMethod.getAnnotation(DataSource.class);
        if (ds == null) {
            throw new Error("Test method has no @DataSource annotation: " + testMethod.getName());
        }

        switch (ds.type()) {
            case RESOURCE:
                return loadDataFromResource(ds.value());

            case FILE:
                return loadDataFromFile(ds.value());
            default:
                throw new Error("Data source type is not supported: " + ds.type());
        }
    }


    private static Object[][] loadDataFromResource(String value) throws IOException {
        return loadDataFromInputStream(UniversalDataProviders.class.getResourceAsStream(value));
    }

    private static Object[][] loadDataFromFile(String value) throws IOException {
        return loadDataFromInputStream(new FileInputStream(new File(value)));
    }

    private static Object[][] loadDataFromInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line;
        while ((line = reader.readLine())!= null) {
            userData.add(new Object[]{line});
//            line = reader.readLine();
        }

        reader.close();

        return (Object[][]) userData.toArray(new Object[][]{});
    }
}
