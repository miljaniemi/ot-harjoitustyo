/**
 * Luokka, joka sisältää tektikäyttöliittymän
 */
package studyingcalendar.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

    /**
     * Metodi, jossa määritellään tarvittavat parametrit, sekä komennot
     *
     * @param reader lukija, joilla saadaan komennot
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
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

    /**
     * Metodi, jota kutsutaan mainista ja tässä metodissa päätetään, onko
     * käyttäjä ylläpitäjä vai oppilas
     *
     * @throws Exception
     */
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

    /**
     * Metodi tulostaa ylläpitäjän komentojen ohjeet
     */
    private void printHostInstructors() {
        System.out.println("1 add a course \n2 delete a course \nx stop");
    }

    /**
     * Metodi tulostaa oppilaan komentojen ohjeet
     */
    private void printStudentInstructors() {
        System.out.println("1 show specific period \n2 show autumn \n3 show spring \n4 show all \nx stop");
    }

    /**
     * Metodi päivittää kalenterin tallennetut kurssit
     *
     * @throws Exception
     */
    private void calendarUpToDate() throws Exception {
        if (dao.courses.isEmpty() == false) {
            for (Course course : dao.courses) {
                calendar.addCourse(course);
            }
        }
    }

    /**
     * Metodi, jota käytetään kun on oppilaana, voi valita haluaako tutkia yhtä
     * periodia, syksyn tai kevään periodeja sekä kaikkia periodeja
     *
     * @throws Exception
     */
    private void youreStudent() throws Exception {
        System.out.println("You're a student!");
        printStudentInstructors();
        while (true) {
            String command = reader.nextLine();
            if (!studentCommands.keySet().contains(command)) {
                invalidCommandStudent();
            } else if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                showPeriod();
            } else if (command.equals("2")) {
                showAutumn();
            } else if (command.equals("3")) {
                showSpring();
            } else if (command.equals("4")) {
                showAll();
            }
        }
    }

    /**
     * Metodi, jonka avulla checkstyle toimii ja sitö kusutaan kun opiskelija
     * antaa väärän komennon.
     */
    private void invalidCommandStudent() {
        System.out.println("Invalid command");
        printStudentInstructors();
    }

    /**
     * Metodi, kun on ylläpitäjä, voi lisätä tai poistaa kursseja
     *
     * @throws Exception
     */
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
            } else if (command.equals("2")) {
                deleteCourse();
            }
        }
    }

    /**
     * Ylläpitäjän metodi, voi lisätä kurssin syötteen avulla
     *
     * @param r lukija
     * @throws Exception
     */
    private void addCourse() throws Exception {
        try {
            System.out.print("Name of the course: ");
            String name = reader.nextLine();
            System.out.print("In which period? (give as a number): ");
            int period = Integer.parseInt(reader.nextLine());
            if (period < 1 || period > 4) {
                System.out.println("There's only periods 1,2,3 and 4");
            } else {
                System.out.print("How many credits?: ");
                int credit = Integer.parseInt(reader.nextLine());
                if (credit < 1 || credit > 25) {
                    System.out.println("Not realistic amount. Try between 1-25");
                } else {
                    Course course = new Course(name, period, credit, false);
                    if (courseAlreadyExist(course) == true) {
                        System.out.println("This course already exist!");
                    } else {
                        calendar.addCourse(course);
                        dao.create(course);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid format, use numbers");
        }
    }

    /**
     * Ylläpitäjän metodi kurssin poistamista varten
     *
     * @param r lukija
     * @throws Exception
     */
    private void deleteCourse() throws Exception {
        try {
            System.out.print("Name of the course you want to delete: ");
            String name = reader.nextLine();
            System.out.print("In which period? (give as a number): ");
            int per = Integer.parseInt(reader.nextLine());
            if (per < 1 || per > 4) {
                System.out.println("There's only periods 1,2,3 and 4");
            } else {
                for (Course c : calendar.getList(per)) {
                    if (c.getName().equals(name) && c.getPeriod() == per) {
                        calendar.deleteCourse(c);
                        dao.delete(c);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid format, use numbers");
        }

    }

    /**
     * Oppilaan metodi, jossa voi valita mitä periodia haluaa tarkastella
     *
     * @param r lukija
     * @throws Exception
     */
    private void showPeriod() throws Exception {
        try {
            System.out.print("Which period do you wish to see? (give as a number): ");
            int p = Integer.parseInt(reader.nextLine());
            if (p < 1 || p > 4) {
                System.out.println("There's only periods 1,2,3 and 4");
            } else {
                for (Course course : calendar.getList(p)) {
                    System.out.println(course.getName() + ", " + course.getCredit() + " credits");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid format, use numbers");
        }
    }

    /**
     * Oppilaan metodi, palauttaa syksyn periodien kurssit.
     *
     * @throws Exception
     */
    private void showAutumn() throws Exception {
        System.out.println("ﾟ✧ Autumn periods ✧ﾟ");
        System.out.println("");
        System.out.println("First period:");
        for (Course course : calendar.getList(1)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
        System.out.println("Second period:");
        for (Course course : calendar.getList(2)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
    }

    /**
     * Oppilaan metodi, joka palauttaa kevään perioidien kurssit
     * @throws Exception 
     */
    private void showSpring() throws Exception {
        System.out.println("ﾟ✧ Spring periods ✧ﾟ\n\nThird period:");
        for (Course course : calendar.getList(3)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nFourth period:");
        for (Course course : calendar.getList(4)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
    }

    /**
     * Oppilaan metodi, joka palauttaa kaikki 4 periodia ja niiden sisältämät kurssit
     * @throws Exception 
     */
    private void showAll() throws Exception {
        System.out.println("First period:");
        for (Course course : calendar.getList(1)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nSecond period:");
        for (Course course : calendar.getList(2)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nThird period:");
        for (Course course : calendar.getList(3)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("\nFourth period:");
        for (Course course : calendar.getList(4)) {
            System.out.println(course.getName() + ", " + course.getCredit() + " credits");
        }
        System.out.println("");
    }
    
    /**
     * Metodi, joka tarkistaa onko samaa kurssia aiemmin luotu, jottai ole samaa kurssia useaan kertaan
     * @param course kurssi, jota verrataan muihin
     * @return kurssi jo olemassa (true) tai sitä ei ole (false)
     * @throws Exception 
     */
    
    private boolean courseAlreadyExist(Course course) throws Exception {
        String name = course.getName();
        int period = course.getPeriod();
        for (Course c : calendar.getList(period)) {
            if (c.getName().matches(name) && c.getPeriod() == period) {
                return true;
            }
        }
        return false;
    }

}
