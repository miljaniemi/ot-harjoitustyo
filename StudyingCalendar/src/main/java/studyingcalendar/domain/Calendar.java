/**
 * Luokka nimensä mukaan toimii kalenterina,
 * jossa näkee missä periodeissa eri kurssit ovat
 */
package studyingcalendar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import studyingcalendar.domain.Course;

public class Calendar {

    ArrayList<Course> firstPeriod;
    ArrayList<Course> secondPeriod;
    ArrayList<Course> thirdPeriod;
    ArrayList<Course> fourthPeriod;
    Course course;

    public Calendar() {
        firstPeriod = new ArrayList<>();
        secondPeriod = new ArrayList<>();
        thirdPeriod = new ArrayList<>();
        fourthPeriod = new ArrayList<>();
    }

    /**
     * Metodi lisää kurssin tiettyyn periodiin kalenterinäkymää varten
     * 
     * @param course kurssi, jonka käyttäjä on antanyt tekstikäyttöliittymässä
     * 
     */
    
    public void addCourse(Course course) {
        int period = course.getPeriod();

        if (period == 1) {
            firstPeriod.add(course);
        } else if (period == 2) {
            secondPeriod.add(course);
        } else if (period == 3) {
            thirdPeriod.add(course);
        } else if (period == 4) {
            fourthPeriod.add(course);
        }
    }
    
    /** 
     * Metodi poistaa kursseja näkyvistä
     * 
     * @param course kurssi, jonka käyttäjä on antanyt tekstikäyttöliittymässä
     */
    
    public void deleteCourse(Course course) {
        int period = course.getPeriod();
        
        if (period == 1) {
            firstPeriod.remove(course);
        } else if (period == 2) {
            secondPeriod.remove(course);
        } else if (period == 3) {
            thirdPeriod.remove(course);
        } else if (period == 4) {
            fourthPeriod.remove(course);
        }
    }
    
    /**
     * Metodi, joka palauttaa listana jonkin tietyn periodin.
     * @param period periodi, jonka lista halutaan
     * @return 
     */
    public ArrayList<Course> getList(int period) {
        if (period == 1) {
            return firstPeriod;
        } else if (period == 2) {
            return secondPeriod;
        } else if (period == 3) {
            return thirdPeriod;
        } else if (period == 4) {
            return fourthPeriod;
        }
        return null;
    }

}
