package calendartest;



import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import calendar.Calendar;
import course.Course;


public class CalendarTest {
    
    public CalendarTest() {
    }
 
    @Test
    public void courseCanBeFoundFromSpecificPeriod() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohpe);
        assertEquals(calendar.showPeriod(1),"Ohjelmoinnin perusteet, 5 credits");
    }
    
    @Test
    public void twoCoursesReturnedWhenTwoAddded() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",1,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohpe);
        Course lama = new Course("Laskennan mallit",1,5,false);
        calendar.addCourse(lama);
        assertEquals(calendar.showPeriod(1),"Ohjelmoinnin perusteet, 5 credits");
    }
}
