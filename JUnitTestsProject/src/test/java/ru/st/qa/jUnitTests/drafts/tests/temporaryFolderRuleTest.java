package ru.st.qa.jUnitTests.drafts.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class temporaryFolderRuleTest {

    @Rule
    public TemporaryFolder tmpDir = new TemporaryFolder();

    @Test
    public void test(){
        System.out.println(tmpDir.getRoot());
    }
}
