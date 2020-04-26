/**
 * Main luokka, jossa kutsutaan tekstikäyttöliittymää
 */
package studyingcalendar.main;

import studyingcalendar.domain.Course;
import studyingcalendar.domain.Calendar;
import java.util.Scanner;
import studyingcalendar.ui.TextInterface;
import studyingcalendar.ui.TextInterface;

public class Main {

    /**
     * Main metodi, kutsuu tekstikäyttöliittymää
     * @param args -
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        TextInterface user = new TextInterface(reader);
        user.start();
        System.out.println("Goodbye");
    }
    
    
}
