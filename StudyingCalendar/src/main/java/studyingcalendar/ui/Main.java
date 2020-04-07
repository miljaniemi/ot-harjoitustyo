
package studyingcalendar.ui;

import studyingcalendar.domain.Course;
import studyingcalendar.domain.Calendar;
import java.util.Scanner;
import studyingcalendar.ui.User;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        User user = new User(reader);
        user.start();
        System.out.println("Goodbye");
    }
    
    
}
