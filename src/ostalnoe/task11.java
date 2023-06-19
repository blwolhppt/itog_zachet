package ostalnoe;

import java.util.Scanner;

public class task11 {
    public static long factorial(int n){
        if (n == 0|| n == 1){
            return 1;
        } else {
            return n * factorial(n-1);
        }

    }

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long result = factorial(n);
        System.out.println(result);

    }

}
