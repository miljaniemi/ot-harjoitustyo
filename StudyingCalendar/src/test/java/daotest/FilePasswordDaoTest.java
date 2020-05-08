/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import studyingcalendar.dao.FilePasswordDao;
import studyingcalendar.dao.PasswordDao;

/**
 *
 * @author nmilja
 */
public class FilePasswordDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File passwordFile;
    PasswordDao dao;
    
    @Before
    public void setUp() throws IOException, Exception {
        passwordFile = testFolder.newFile("testpassword.txt");

        dao = new FilePasswordDao(passwordFile.getAbsolutePath());
    }

    @Test
    public void AddingANewPasswordWorks() throws Exception {
        dao.save("password");
        assertEquals("password", dao.getPassword());
    }
    
    
    @After
    public void tearDown() {
        passwordFile.delete();
    }
}
