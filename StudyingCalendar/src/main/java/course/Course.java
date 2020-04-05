
package course;

public class Course {
    
    private String name;
    private int period;
    private int credit;
    private boolean done;
    
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPeriod(int period) {
        this.period = period;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public void setDone(boolean done) {
        this.done = done;
    }
}
