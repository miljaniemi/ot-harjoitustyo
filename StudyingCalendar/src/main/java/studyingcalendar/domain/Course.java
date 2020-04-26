/**
 * Luokka, jossa kursseja kalenteria arten
 */

package studyingcalendar.domain;

public class Course {
    
    private String name;
    private int period;
    private int credit;
    private boolean done;
    
    /**
     * Kurssin parametrit omaava metodi
     * @param name kurssin nimi
     * @param period periodi missä kurssi käydään
     * @param credit kuinka monta opintopistettä kyseisestä kurssista saa
     * @param done onko käyty vai ei
     */
    public Course(String name, int period, int credit, boolean done) {
        this.name = name;
        this.period = period;
        this.credit = credit;
        this.done = done;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPeriod() {
        return this.period;
    }
    
    public int getCredit() {
        return this.credit;
    }
    
    public boolean getDone() {
        return this.done;
    }
    
    public void setDone(boolean done) {
        this.done = done;
    }
}