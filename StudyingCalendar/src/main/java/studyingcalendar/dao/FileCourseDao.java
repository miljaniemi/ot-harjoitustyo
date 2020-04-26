/**
 * Luokka joka tallentaa talteen kussit
 */

package studyingcalendar.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import studyingcalendar.domain.Course;

public class FileCourseDao implements CourseDao {

    public List<Course> courses;
    private String file;

    /**
     * Metodi joka lukee tiedostoa ja sen kautta tuo kurssit tallesta
     * @param file tiedosto ,jossa on nämä kurssit
     * @throws Exception 
     */
    public FileCourseDao(String file) throws Exception {
        courses = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int period = Integer.parseInt(parts[1]);
                int credit = Integer.parseInt(parts[2]);
                boolean done = Boolean.parseBoolean(parts[3]);
                Course course = new Course(parts[0], period, credit, done);
                courses.add(course);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    /**
     * Metodi, joka tallentaa uudet kurssit talteen
     * @throws Exception 
     */
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Course course : courses) {
                writer.write(course.getName() + ";" + course.getPeriod() + ";" + course.getCredit() + ";" + course.getDone() + "\n");
            }
        }
    }

    /**
     * Metodi joka nimensä mukaan tekee kurssit, tätä kutsutaan kun tehdään uusi kurssi. 
     * @param course Kurssi, jonka käyttäjä on luonut testikäyttöliittymässä
     * @return kurssin
     * @throws Exception 
     */
    @Override
    public Course create(Course course) throws Exception {
        courses.add(course);
        save();
        return course;
    }

        /**
     * Metodi joka nimensä mukaan poistaa kurssit, tätä kutsutaan kun poistetaan kurssi. 
     * @param course Kurssi, joka halutaan poistaa
     * @return kurssin
     * @throws Exception 
     */
    @Override
    public Course delete(Course course) throws Exception {
        courses.remove(course);
        save();
        return course;
    }

    
}