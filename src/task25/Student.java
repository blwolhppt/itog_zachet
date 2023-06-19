package task25;

public class Student extends User{
    private int stipendia;
    private int course;

    public Student(String name, int age, int stipendia, int course){
        super(name, age);
        this.stipendia = stipendia;
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public int getStipendia() {
        return stipendia;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setStipendia(int stipendia) {
        this.stipendia = stipendia;
    }
}
