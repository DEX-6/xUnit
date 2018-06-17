package ru.st.qa.jUnitTests.tests;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.SoftAssertions;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import ru.st.qa.jUnitTests.annotations.DataSource;
import ru.st.qa.jUnitTests.categories.MyCategories.IgnoreTest;
import ru.st.qa.jUnitTests.categories.MyCategories.NegativeTest;
import ru.st.qa.jUnitTests.categories.MyCategories.PositiveTest;
import ru.st.qa.jUnitTests.dataProviders.UniversalDataProviders;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by i-ru on 25.04.2018.
 */

@RunWith(DataProviderRunner.class)
public class CreateNewFileTest {
    private Path path;
    /*
    * Позитивный тест,
    * Проверка 1, что можносоздать один файл
    * Проверка 2, что файл создан в нужной директории
    * */
    @Test()
    @Category(PositiveTest.class)
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
    @DataSource(value = "/filesNamesSource.txt", type = DataSource.Type.RESOURCE)
    public void checkPath(String fileName) throws IOException {
        SoftAssertions softAssertions = new SoftAssertions();
        System.out.println(String.format("Создаем первый файл с именем %s", fileName));
        File file_1 = new File(path.toString() + "/" + fileName);
        boolean firstFileCreationResult = file_1.createNewFile();
        System.out.println("Проверка создания файла!!!!");
        softAssertions.assertThat(firstFileCreationResult);
        System.out.println("Проверка создания файла выполнена");
        System.out.println("Получаем путь файла");
        String parentPath = file_1.getParent();
        String pathString = path.toString();
        System.out.println(String.format("Путь файла = \"%s\"", pathString));
        softAssertions.assertThat(pathString.equals(parentPath));
        System.out.println("Проверка нахождения в нужной директории выполнена");
        softAssertions.assertAll();
        System.out.println("Собираем результаты выполнения проверок");
    }

    /*
     * Негативный тест, что нельзя создать файл с одним и тем же названием в одной и той же директории дважды
     */
    @Test
    @Category(NegativeTest.class)
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
    @DataSource(value = "/filesNamesSource.txt", type = DataSource.Type.RESOURCE)
    public void checkDoubleFileCreationTest(String fileName) throws IOException {
        System.out.println(String.format("Создаем первый файл с именем %s", fileName));
        File file_1 = new File(path.toString() + "/" + fileName);
        boolean firstFileCreationResult = file_1.createNewFile();
        Assert.assertTrue(firstFileCreationResult);
        System.out.println("Проверка создания файла выполнениа");


        System.out.println(String.format("Создаем второй файл с именем %s", fileName));
        File file_2 = new File(path.toString() + "/" + fileName);
        boolean secondFileCreationResult = file_2.createNewFile();

        Assert.assertTrue(!secondFileCreationResult);
        System.out.println("Проверка повторного создания выполнена. Повторного создания файла не произошло");

    }

    /*
    * Негативный тест, что нельзя создать файл в несуществующей директории
    */
    @Test
    @Category({NegativeTest.class, IgnoreTest.class})
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProviders.class)
    @DataSource(value = "/filesNamesSource.txt", type = DataSource.Type.RESOURCE)

    public void checkCreationFileinFakeDirectory(String fileName) {
        System.out.println(String.format("Создаем первый файл с именем %s", fileName));
        String fakeDirectory = "qwerty";
        boolean creationResult = false;
        File file;
        try {
            file = new File(fakeDirectory + "/" + fileName);
            creationResult = file.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(creationResult == false);
        System.out.println("Выполнена проверка, что нельзя создать файл в несуществующей директории");
    }

    @Rule
    public final ExternalResource externalResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("--------------------------------------------------");
            path = Files.createTempDirectory("temporaTemporis");
            System.out.println(String.format("Создана директория \"%s\"", path));
        }

        @Override
        protected void after() {
            try {
                Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println("Удален файл " + file.toString());
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        System.out.println("Удалена директория " + dir.toString());
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

}
