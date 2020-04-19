package studyingcalendar.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import studyingcalendar.domain.Calendar;
import studyingcalendar.domain.Course;

public class FileCalendarDao implements CalendarDao {

    ArrayList<Course> firstPeriod;
    ArrayList<Course> secondPeriod;
    ArrayList<Course> thirdPeriod;
    ArrayList<Course> fourthPeriod;

    private String file;

    public FileCalendarDao(String file) throws Exception {
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int period = Integer.parseInt(parts[1]);
                int credit = Integer.parseInt(parts[2]);
                boolean done = Boolean.parseBoolean(parts[3]);
                Course course = new Course(parts[0], period, credit, done);
                addCourse(course);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public Calendar addCourse(Course course) throws Exception {
        Calendar calendar = new Calendar();
        firstPeriod = new ArrayList<>();
        secondPeriod = new ArrayList<>();
        thirdPeriod = new ArrayList<>();
        fourthPeriod = new ArrayList<>();
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
        return calendar;
    }

}
