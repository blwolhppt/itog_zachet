package task23;

public class Complex {
    private int[] array = new int[2];

    public Complex(int a, int b){
        array[0] = a;
        array[1] = b;
    }

    public int[] getArray() {
        return array;
    }


    public Complex sum(Complex a, Complex b){
        return new Complex(a.getArray()[0]+b.getArray()[0], a.getArray()[1]+b.getArray()[1]);
    }

    public Complex dif(Complex a, Complex b){
        return new Complex(a.getArray()[0]-b.getArray()[0], a.getArray()[1]-b.getArray()[1]);
    }

}
