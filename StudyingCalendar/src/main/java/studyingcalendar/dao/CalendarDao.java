package studyingcalendar.dao;

import java.util.List;
import studyingcalendar.domain.Calendar;
import studyingcalendar.domain.Course;

public interface CalendarDao {

    Calendar addCourse(Course course) throws Exception;
    
}
