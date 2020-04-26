package studyingcalendar.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import studyingcalendar.domain.Calendar;
import studyingcalendar.domain.Course;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;
import studyingcalendar.dao.FileCourseDao;

public class TextInterface {

    private Scanner reader;
    private Map<String, String> studentOrHost;
    private Map<String, String> hostCommands;
    private Map<String, String> studentCommands;
    private Course course;
    private Calendar calendar;
    private FileCourseDao dao;

    public TextInterface(Scanner reader) throws FileNotFoundException, IOException, Exception {
        this.reader = reader;
        calendar = new Calendar();
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String courseFile = properties.getProperty("courseFile");
        dao = new FileCourseDao(courseFile);
        studentOrHost = new TreeMap<>();
        hostCommands = new TreeMap<>();
        studentCommands = new TreeMap<>();
        studentOrHost.put("1", "1 host");
        studentOrHost.put("2", "2 student");
        studentOrHost.put("x", "x stop");
        hostCommands.put("x", "x stop");
        hostCommands.put("1", "1 add a course");
        hostCommands.put("2", "2 delete a course");
        studentCommands.put("1", "1 show specific period");
        studentCommands.put("2", "2 show autumn");
        studentCommands.put("3", "3 show spring");
        studentCommands.put("4", "4 show all");
        studentCommands.put("x", "stop");
    }

    public void start() throws Exception {
        calendarUpToDate();
        System.out.println("Welcome! Are you a student or a host?\n1 host or 2 student");
        while (true) {
            String command = reader.nextLine();
            if (!studentOrHost.keySet().contains(command)) {
                System.out.println("Invalid command");
                System.out.println("Are you a student or a host?");
            }
            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                youreHost();
                break;

            } else if (command.equals("2")) {
                youreStudent();
                break;
            }
        }
    }

    private void printHostInstructors() {
        System.out.println("1 add a course \n2 delete a course \nx stop");
    }

    private void printStudentInstructors() {
        System.out.println("1 show specific period \n2 show autumn \n3 show spring \n4 show all \nx stop");
    }

    private void calendarUpToDate() throws Exception {
        if (dao.courses.isEmpty() == false) {
            for (Course course : dao.courses) {
                calendar.addCourse(course);
            }
        }
    }

    private void youreStudent() throws Exception {
        System.out.println("You're a student!");
        printStudentInstructors();
        while (true) {
            String command = reader.nextLine();
            if (!studentCommands.keySet().contains(command)) {
                System.out.println("Invalid command");
                printStudentInstructors();
            } else if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                showPeriod();
                printStudentInstructors();
            } else if (command.equals("2")) {
                calendar.showAutumn();
                printStudentInstructors();
            } else if (command.equals("3")) {
                calendar.showSpring();
                printStudentInstructors();
            } else if (command.equals("4")) {
                calendar.showAll();
                printStudentInstructors();
            }
        }
    }

    private void youreHost() throws Exception {
        System.out.println("You're a host!");
        printHostInstructors();
        while (true) {
            String command = reader.nextLine();
            if (!hostCommands.keySet().contains(command)) {
                System.out.println("Invalid command");
                printHostInstructors();
            } else if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                addCourse();
                printHostInstructors();
            } else if (command.equals("2")) {
                deleteCourse();
                printHostInstructors();
            }
        }
    }

    private void addCourse() throws Exception {
        System.out.print("Name of the course: ");
        String name = reader.nextLine();
        System.out.print("In which period? (give as a number): ");
        int period = reader.nextInt();
        System.out.print("How many credits?: ");
        int credit = reader.nextInt();
        Course course = new Course(name, period, credit, false);
        if (dao.courses.contains(course)) {
            System.out.println("This course already exist!");
        } else {
            calendar.addCourse(course);
            dao.create(course);
        }
    }

    private void deleteCourse() throws Exception {
        System.out.print("Name of the course you want to delete: ");
        String name = reader.nextLine();
        System.out.print("In which period? (give as a number): ");
        int per = reader.nextInt();
        for (Course c : dao.courses) {
            if (c.getName().equals(name) && c.getPeriod() == per) {
                c.setDone(true);
                calendar.deleteCourse(c);
                dao.delete(c);
            }
        }
    }
 
    private void showPeriod() throws Exception {
        System.out.print("Which period do you wish to see? (give as a number): ");
        int p = reader.nextInt();
        calendar.showPeriod(p);
    }
}