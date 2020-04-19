
package studyingcalendar.dao;

import java.util.List;
import studyingcalendar.domain.Course;

public interface CourseDao {
    
    public Course create(Course arg0) throws Exception;

    public List<Course> getAll();

    public void setDone(int arg0) throws Exception;
    
}
