package calendartest;



import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import studyingcalendar.domain.Calendar;
import studyingcalendar.domain.Course;


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
    public void courseIsNotFoundWhenIncorrectPeriod() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",6,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohpe);
        assertEquals(calendar.showPeriod(6),"");
        assertEquals(calendar.showPeriod(1),"");
        assertEquals(calendar.showPeriod(2),"");
        assertEquals(calendar.showPeriod(3),"");
        assertEquals(calendar.showPeriod(4),"");
    }
}
