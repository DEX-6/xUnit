package ru.st.qa.testsNg.dataProviders;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by i-ru on 04.06.2018.
 */
public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> externalFileNameGenerator() throws IOException {
        List<Object[]> data = new ArrayList<>();
        File file = new File("src/test/resources/filesNamesSource.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while ((line = reader.readLine())!= null){
            data.add(new Object[]{line});
        }
        reader.close();
        return data.iterator();
    }

}
