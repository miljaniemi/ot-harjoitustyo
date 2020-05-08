
package daotest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import studyingcalendar.dao.CourseDao;
import studyingcalendar.dao.FileCourseDao;
import studyingcalendar.domain.Course;

public class FileCourseDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File courseFile;
    CourseDao dao;
    
    @Before
    public void setUp() throws IOException, Exception {
        courseFile = testFolder.newFile("testcourses.txt");
        
        try (FileWriter file = new FileWriter(courseFile.getAbsolutePath())) {
            file.write("TestiKurssi;1;10;false\n");
        }
        
        dao = new FileCourseDao(courseFile.getAbsolutePath());
    }
    
    @Test
    public void courseCanBeFoundFromTheFile() throws Exception {
        List<Course> courses = dao.allCourses();
        assertEquals(1, courses.size());
        Course course = courses.get(0);
        assertEquals("TestiKurssi", course.getName());
        assertEquals(1,course.getPeriod());
        assertEquals(10,course.getCredit());
    }
    
    @Test
    public void newCourseCanBeAdded() throws Exception {
        Course testohte = new Course("Testi Ohjelmistotekniikka",4,5);
        dao.create(testohte);
        List<Course> courses = dao.allCourses();
        assertEquals(2, courses.size());
        Course course = courses.get(1);
        assertEquals("Testi Ohjelmistotekniikka", course.getName());
        assertEquals(4,course.getPeriod());
        assertEquals(5,course.getCredit());
    }
    
    @Test
    public void courseCanBeDeleted() throws Exception {
        Course testohte = new Course("Testi Ohjelmistotekniikka",4,5);
        dao.create(testohte);
        dao.delete(testohte);
        List<Course> courses = dao.allCourses();
        assertEquals(1, courses.size());
    }
    
    @After
    public void tearDown() {
        courseFile.delete();
    }

    
}
