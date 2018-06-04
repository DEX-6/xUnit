package ru.st.qa.testsNg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by i-ru on 25.04.2018.
 */
public class CreateNewFileTest {
    private Path path;

    @BeforeClass(alwaysRun = true)
    public void createTempDirectory() throws IOException {
        path = Files.createTempDirectory("temporaTemporis");
        System.out.println(String.format("Создана директория \"%s\"", path));
    }


    /*
    * Позитивный тест,
    * Проверка 1, что можносоздать один файл
    * Проверка 2, что файл создан в нужной директории
    * */
    @Test(groups = {"positive"})
    public void checkPath() throws IOException {
        SoftAssert softAssert = new SoftAssert();
        String fileName = "TempFile_1";
        System.out.println(String.format("Создаем первый файл с именем %s", fileName));
        File file_1 = new File(path.toString() + "/" + fileName);
        boolean firstFileCreationResult = file_1.createNewFile();
        softAssert.assertTrue(firstFileCreationResult, "Проверка создания файла!!!!");
        System.out.println("Проверка создания файла выполнена");
        System.out.println("Получаем путь файла");
        String parentPath = file_1.getParent();
        String pathString = path.toString();
        System.out.println(String.format("Путь файла = \"%s\"", pathString));
        softAssert.assertTrue(pathString.equals(parentPath));
        softAssert.assertEquals(parentPath, pathString, "Проверка пути!!!!!!!!");
        System.out.println("Проверка нахождения в нужной директории выполнена");
        softAssert.assertAll();
        System.out.println("Собираем результаты выполнения проверок");
    }

    /*
     * Негативный тест, что нельзя создать файл с одним и тем же названием в одной и той же директории дважды
     */
    @Test(groups = {"negative"})
    public void checkDoubleFileCreationTest() throws IOException {
        String fileName = "TempFile_2";
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

    @Test(groups = {"negative"})
    public void checkCreationFileinFakeDirectory() {
        String fileName = "TempFile_3";
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

    @AfterClass(alwaysRun = true)
    public void deleteDirectory() throws IOException {

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

}
