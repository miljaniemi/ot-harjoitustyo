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
    File passwordFile2;
    PasswordDao dao;
    PasswordDao dao2;
    
    @Before
    public void setUp() throws IOException, Exception {
        passwordFile = testFolder.newFile("testpassword.txt");
        passwordFile2 = testFolder.newFile("test2password.txt");

        try (FileWriter file = new FileWriter(passwordFile2.getAbsolutePath())) {
            file.write("password;\n");
        }
        
        dao = new FilePasswordDao(passwordFile.getAbsolutePath());
        dao2 = new FilePasswordDao(passwordFile2.getAbsolutePath());
    }

    @Test
    public void noPasswordReturnsNull() throws Exception {
        assertEquals(null, dao.getPassword());
    }
    
    @Test
    public void AddingANewPasswordWorks() throws Exception {
        dao.save("password");
        assertEquals("password", dao.getPassword());
    }
    
    @Test
    public void PreAddedPasswordIsThere() throws Exception {
        assertEquals("password", dao2.getPassword());
    }
    
    @After
    public void tearDown() {
        passwordFile.delete();
    }
}
