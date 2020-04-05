package coursetest;



import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import course.Course;


public class CourseTest {
    
    public CourseTest() {
    }

    @Test
    public void AddingANewCourseWorks() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5,false);
        assertEquals(ohpe.getName(),"Ohjelmoinnin perusteet");
        assertEquals(ohpe.getCredit(), 5);
        assertEquals(ohpe.getPeriod(), 1);
        assertEquals(ohpe.getDone(), false);
    }
    
    @Test
    public void ChangingPeriodWorks() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5,false);
        ohpe.setPeriod(3);
        assertEquals(ohpe.getPeriod(),3);
    }
    
    @Test
    public void ChangingCreditsWorks() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,10,false);
        ohpe.setCredit(5);
        assertEquals(ohpe.getCredit(),5);
    }
    
    @Test
    public void ChangingNameWorks() {
        Course ohpe = new Course("Ohpe",1,5,false);
        ohpe.setName("Ohjelmoinnin perusteet");
        assertEquals(ohpe.getName(),"Ohjelmoinnin perusteet");
    }
    
}
