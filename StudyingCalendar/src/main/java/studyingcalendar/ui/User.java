package user.ui;

import calendar.Calendar;
import course.domain.Course;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class User {

    private Scanner reader;
    private Map<String, String> studentOrHost;
    private Map<String, String> hostCommands;
    private Map<String, String> studentCommands;
    private Course course;
    private Calendar calendar;

    public User(Scanner reader) {
        this.reader = reader;
        studentOrHost = new TreeMap<>();
        hostCommands = new TreeMap<>();

        studentOrHost.put("1", "1 host");
        studentOrHost.put("2", "2 student");
        studentOrHost.put("x", "x stop");

        hostCommands.put("x", "x stop");
        hostCommands.put("1", "1 add a course");
        hostCommands.put("2", "2 delete a course");
    }

    public void start() {
        System.out.println("Welcome! Are you a student or a host?");
        System.out.println("1 host or 2 student");
        while (true) {
            String command = reader.nextLine();
            if (!studentOrHost.keySet().contains(command)) {
                System.out.println("Invalid command");
                System.out.println("Are you a student or a host?");
            }

            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                System.out.println("You're a host!");
                printHostInstructors();
                break;
            } else if (command.equals("2")) {
                System.out.println("You're a student!");
                break;
            }
        }
    }

    private void printHostInstructors() {
        System.out.println("1 add a course \n2 delete a course \nx stop");
    }

    private void addCourse() {
        System.out.print("Name of the course: ");
        String name = reader.nextLine();
        System.out.print("In which period? (give as a number): ");
        int period = reader.nextInt();
        System.out.print("How many credits?: ");
        int credit = reader.nextInt();
        calendar.addCourse(new Course(name, period, credit, false));
    }
}
