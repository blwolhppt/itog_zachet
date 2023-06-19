package ostalnoe;

import java.util.Scanner;

public class task3 {
    public static void main (String[]args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String str_n = Integer.toString(n);

        for(int i = 0; i < str_n.length(); i++){
            System.out.println(str_n.charAt(i));

        }
    }

}
