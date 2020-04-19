package studyingcalendar.dao;

import java.util.List;
import studyingcalendar.domain.Calendar;

public interface CalendarDao {

    public Calendar create(Calendar arg0) throws Exception;

    public List<Calendar> getAll();

    public void setDone(int arg0) throws Exception;
    
}
