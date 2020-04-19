
package studyingcalendar.dao;

import java.util.List;
import studyingcalendar.domain.Course;

public interface CourseDao {
    
    Course create(Course course) throws Exception;
    List<Course> getAll();

}
