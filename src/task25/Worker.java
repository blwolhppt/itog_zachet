package task25;

public class Worker extends User{
    private int salary;

    public Worker(String name, int age,  int salary){
       super(name, age);
       this.salary = salary;
    }
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
