package calendartest;

import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import studyingcalendar.domain.Calendar;
import studyingcalendar.domain.Course;

public class CalendarTest {

    private Calendar calendar = new Calendar();

    public CalendarTest() {
    }

    @Test
    public void periodIsEmpty() {
        ArrayList<Course> first = calendar.getList(1);
        assertEquals(first.size(), 0);
    }

    @Test
    public void nullPeriodWhenIncorrectPeriodNumber() {
        assertEquals(calendar.getList(5), null);
    }

    @Test
    public void addingCourseWorks() {
        Course test = new Course("TestCourse", 2, 5);
        calendar.addCourse(test);
        ArrayList<Course> second = calendar.getList(2);
        assertEquals(second.size(), 1);
    }

    @Test
    public void addingMultipleAndToDifferentPeriodsWorks() {
        Course test1 = new Course("TestCourse1", 3, 5);
        Course test2 = new Course("TestCourse2", 3, 5);
        Course test3 = new Course("TestCourse3", 4, 5);
        calendar.addCourse(test3);
        calendar.addCourse(test2);
        calendar.addCourse(test1);
        ArrayList<Course> third = calendar.getList(3);
        assertEquals(third.size(), 2);
        ArrayList<Course> fourth = calendar.getList(4);
        assertEquals(fourth.size(), 1);
    }

    @Test
    public void deletingACourseWorks() {
        Course one = new Course("TestCourse1", 1, 5);
        Course two = new Course("TestCourse2", 2, 5);
        Course three = new Course("TestCourse3", 3, 5);
        Course four = new Course("TestCourse4", 4, 5);
        calendar.addCourse(one);
        calendar.addCourse(two);
        calendar.addCourse(three);
        calendar.addCourse(four);
        calendar.deleteCourse(one);
        calendar.deleteCourse(two);
        calendar.deleteCourse(three);
        calendar.deleteCourse(four);
        ArrayList<Course> first = calendar.getList(1);
        assertEquals(first.size(), 0);
        ArrayList<Course> second = calendar.getList(2);
        assertEquals(second.size(), 0);
        ArrayList<Course> third = calendar.getList(3);
        assertEquals(third.size(), 0);
        ArrayList<Course> fourth = calendar.getList(4);
        assertEquals(fourth.size(), 0);
    }
    
}
