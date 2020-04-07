
package studyingcalendar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import studyingcalendar.domain.Course;

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

    public String showPeriod(int period) {
        if (period == 1) {
            for (Course course : firstPeriod) {
                return course.getName() + ", " + course.getCredit() + " credits";
            }
        } else if (period == 2) {
            for (Course course : secondPeriod) {
                return course.getName() + ", " + course.getCredit() + " credits";
            }
        } else if (period == 3) {
            for (Course course : thirdPeriod) {
                return course.getName() + ", " + course.getCredit() + " credits";
            }
        } else if (period == 4) {
            for (Course course : fourthPeriod) {
                return course.getName() + ", " + course.getCredit() + " credits";
            }
        }
        return "";
    }

    public void showAll() {
        System.out.println("First period:");
        for (Course course : firstPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nSecond period:");
        for (Course course : secondPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nThird period:");
        for (Course course : thirdPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nFourth period:");
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
        System.out.println("ﾟ✧ Spring periods ✧ﾟ\n\nThird period:");
        for (Course course : thirdPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nFourth period:");
        for (Course course : fourthPeriod) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
    }

}
