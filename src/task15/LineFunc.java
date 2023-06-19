package task15;

public class LineFunc extends Grafic{
    private final double k;
    private final double l;

    public LineFunc(double k, double l){
        this.k = k;
        this.l = l;
    }

    @Override
    public void calcfunction(double x) {
        System.out.println(k * x + l);
    }


    public static void main(String[] args) {
        LineFunc linefunc = new LineFunc(2, 3);
        linefunc.calcfunction(2);
    }
}
