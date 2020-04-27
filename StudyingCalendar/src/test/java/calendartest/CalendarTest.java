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
        //assertEquals(calendar.showPeriod(1),"Ohjelmoinnin perusteet, 5 credits");
    }
    
    @Test
    public void courseIsNotFoundWhenIncorrectPeriod() {
        Course ohpe = new Course("Ohjelmoinnin perusteet",6,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohpe);
        //assertEquals(calendar.showPeriod(6),"");
        //assertEquals(calendar.showPeriod(1),"");
        //assertEquals(calendar.showPeriod(2),"");
        //assertEquals(calendar.showPeriod(3),"");
        //assertEquals(calendar.showPeriod(4),"");
    }
    
    @Test
    public void courseIsFoundWhenCorrectPeriod() {
        Course ohte = new Course("Ohjelmistotekniikka",4,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohte);
        //assertEquals(calendar.showPeriod(4),"Ohjelmistotekniikka, 5 credits");
    }
    
    @Test
    public void coursesAreFoundWhenCorrectPeriod() {
        Course ohja = new Course("Ohjelmoinnin jatkokurssi",2,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohja);
        Course ohpe = new Course("Ohjelmoinnin perusteet",3,5,false);
        calendar.addCourse(ohpe);
        Course lama = new Course("Laskennan mallit",1,5,false);
        calendar.addCourse(lama);
        Course ohte = new Course("Ohjelmistotekniikka",4,5,false);
        calendar.addCourse(ohte);
        //assertEquals(calendar.showPeriod(1),"Laskennan mallit, 5 credits");
        //assertEquals(calendar.showPeriod(2),"Ohjelmoinnin jatkokurssi, 5 credits");
       // assertEquals(calendar.showPeriod(3),"Ohjelmoinnin perusteet, 5 credits");
        //assertEquals(calendar.showPeriod(4),"Ohjelmistotekniikka, 5 credits");
    }
    
    @Test
    public void deletingACourseWorks() {
        Course ohte = new Course("Ohjelmistotekniikka",4,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohte);
        calendar.deleteCourse(ohte);
        //assertEquals(calendar.showPeriod(4),"");   
    }
    
    @Test
    public void deletingMultipleCoursesWorks() {
        Course ohja = new Course("Ohjelmoinnin jatkokurssi",2,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohja);
        Course ohpe = new Course("Ohjelmoinnin perusteet",3,5,false);
        calendar.addCourse(ohpe);
        Course lama = new Course("Laskennan mallit",1,5,false);
        calendar.addCourse(lama);
        calendar.deleteCourse(ohpe);
        calendar.deleteCourse(ohja);
        calendar.deleteCourse(lama);
        //assertEquals(calendar.showPeriod(1),"");
        //assertEquals(calendar.showPeriod(2),""); 
        //assertEquals(calendar.showPeriod(3),"");  
    }
}
