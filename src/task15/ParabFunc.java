package task15;

public class ParabFunc extends Grafic{
    private final double a;
    private final double b;
    private final double c;

    public ParabFunc(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void calcfunction(double x) {
        System.out.println(a * x * x + b * x + c);
    }

    public static void main(String[] args) {
        ParabFunc parabfunc = new ParabFunc(1, 2, 3);
        parabfunc.calcfunction(1);
    }
}
