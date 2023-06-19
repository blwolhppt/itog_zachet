package ostalnoe;

public class RightTriangle extends Triangle {
    public RightTriangle(double a, double b) {
        super(a, b, Math.sqrt(a * a + b * b)); // находим гипотенузу по теореме Пифагора
    }

    public double getHypotenuse() {
        return getSideC();
    }
}
