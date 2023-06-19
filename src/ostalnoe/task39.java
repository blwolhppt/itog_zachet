package ostalnoe;

import java.util.Scanner;

public class task39 {
    public static int nod_recurs(int n, int m){
        if (m == 0){
            return n;
        } else {
            return nod_recurs(m, n % m);
        }
    }

    public static int nod(int n, int m){
        while (m!= 0) {
            int value = m;
            m = n % m;
            n = value;
        }
        return n;
    }

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int answer_recurs = nod_recurs(n, m);
        System.out.println(answer_recurs);

        int answer = nod(n, m);
        System.out.println(answer);





    }
}
