package task25;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Иван", 25, 1000 );
        Worker worker2 = new Worker("Вася", 26, 2000 );
        System.out.println(worker1.getSalary() + worker2.getSalary());


    }
}
