package task16;

public class ArProgress implements Progress{
    private double a;
    private double step;

    public ArProgress(double a, double step){
        this.a = a;
        this.step = step;
    }



    @Override
    public double index(int n) {
        return a + (n - 1) * step;
    }

    @Override
    public double summa(int n) {
        return (2 * a + step * (n - 1)) / 2 * n;
    }

    public static void main(String[] args) {
        ArProgress arprogress = new ArProgress(1, 3);
        System.out.println(arprogress.index(3));
        System.out.println(arprogress.summa(3));
    }
}
