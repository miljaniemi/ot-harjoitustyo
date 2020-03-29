package OhTeProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Calendar {

    ArrayList<Course> firstPeriod = new ArrayList<>();
    ArrayList<Course> secondPeriod = new ArrayList<>();
    ArrayList<Course> thirdPeriod = new ArrayList<>();
    ArrayList<Course> fourthPeriod = new ArrayList<>();
    Course course;

    public Calendar() {

    }

    public void addCourse(Course course) {
        int period = course.getPeriod();
        String name = course.getName();

        if (period == 1) {
            firstPeriod.add(course);
        } else if (period == 2) {
            secondPeriod.add(course);
        } else if (period == 3) {
            thirdPeriod.add(course);
        } else {
            fourthPeriod.add(course);
        }
    }

    public void showPeriod(int period) {
        if (period == 1) {
            for (Course course : firstPeriod) {
                System.out.println(course.getName() + ", " + course.getCredit() + " credits");
            }
        } else if (period == 2) {
            for (Course course : secondPeriod) {
                System.out.println(course.getName() + ", " + course.getCredit() + " credits");
            }
        } else if (period == 3) {
            for (Course course : thirdPeriod) {
                System.out.println(course.getName() + ", " + course.getCredit() + " credits");
            }
        } else {
            for (Course course : fourthPeriod) {
                System.out.println(course.getName() + ", " + course.getCredit() + " credits");
            }
        }
        System.out.println("");
    }

    public void showAll() {
        System.out.println("First period:");
        for (Course course : firstPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
        System.out.println("Second period:");
        for (Course course : secondPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
        System.out.println("Third period:");
        for (Course course : thirdPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
        System.out.println("Fourth period:");
        for (Course course : fourthPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
    }
    
    
    public void showAutumn() {
        System.out.println("ﾟ✧ Autumn periods ✧ﾟ");
        System.out.println("");
        System.out.println("First period:");
        for (Course course : firstPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
        System.out.println("Second period:");
        for (Course course : secondPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
    }
    
    public void showSpring() {
        System.out.println("ﾟ✧ Spring periods ✧ﾟ");
        System.out.println("");
        System.out.println("Third period:");
        for (Course course : thirdPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
        System.out.println("Fourth period:");
        for (Course course : fourthPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
    }
}
