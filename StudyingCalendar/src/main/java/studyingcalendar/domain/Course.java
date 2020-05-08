/**
 * Luokka, jossa kursseja kalenteria arten
 */

package studyingcalendar.domain;

public class Course {
    
    private String name;
    private int period;
    private int credit;
    
    /**
     * Kurssin parametrit omaava metodi
     * @param name kurssin nimi
     * @param period periodi missä kurssi käydään
     * @param credit kuinka monta opintopistettä kyseisestä kurssista saa
     * @param done onko käyty vai ei
     */
    public Course(String name, int period, int credit) {
        this.name = name;
        this.period = period;
        this.credit = credit;
    }
    
    /**
     * Metodi, joka palauttaa kurssin nimen
     * @return kurssin nimi
     */
    
    public String getName() {
        return this.name;
    }
    
    /**
     * Metodi, joka palauttaa periodin, jossa kyseinen kurssi on
     * @return kurssin periodi
     */
    
    public int getPeriod() {
        return this.period;
    }
    
    /**
     * Metodi, joka palauttaa kurssin opintopistemäärän
     * @return kurssin opintopistemäärä
     */
    
    public int getCredit() {
        return this.credit;
    }
}