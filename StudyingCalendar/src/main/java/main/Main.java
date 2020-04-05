
package main;

import course.Course;
import calendar.Calendar;
import java.util.Scanner;
import user.User;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        User user = new User(reader);
        user.start();
        System.out.println("Goodbye");
    }
    
    
}
