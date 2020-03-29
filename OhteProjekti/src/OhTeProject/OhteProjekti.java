
package OhTeProject;

public class OhteProjekti {

    public static void main(String[] args) {
        Course ohte = new Course("Ohjelmistotekniikka",4,5,false);
        Calendar calendar = new Calendar();
        calendar.addCourse(ohte);
        calendar.showPeriod(4);
        Course lama = new Course("Laskennan mallit",1,5,false);
        calendar.addCourse(lama);
        calendar.showAll();
        calendar.showAutumn();
        calendar.showSpring();
    }
    
}
