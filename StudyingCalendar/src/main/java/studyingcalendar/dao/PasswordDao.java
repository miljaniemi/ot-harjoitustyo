package studyingcalendar.dao;

public interface PasswordDao {
    
    String save(String password) throws Exception;
    String getPassword() throws Exception;

}