package coursetest;



import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import studyingcalendar.domain.Course;


public class CourseTest {
    
    public CourseTest() {
    }

    @Test
    public void AddingANewCourseWorks() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5);
        assertEquals(ohpe.getName(),"Ohjelmoinnin perusteet");
        assertEquals(ohpe.getCredit(), 5);
        assertEquals(ohpe.getPeriod(), 1);
    }
    
    @Test
    public void GettingPeriodWorks() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5);
        assertEquals(ohpe.getPeriod(),1);
    }
    
    @Test
    public void GettingCreditsWorks() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5);
        assertEquals(ohpe.getCredit(),5);
    }
    
    @Test
    public void GettingNameWorks() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5);
        assertEquals(ohpe.getName(),"Ohjelmoinnin perusteet");
    }
    
}