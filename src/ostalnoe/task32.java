package ostalnoe;

import java.util.Scanner;

public class task32 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int [][] array = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                array[i][j] = (int)(Math.random()*100) + 1;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


        int max = 0, min = 999, maxRow = 0, maxColumn = 0, minRow = 0, minColumn = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (array[i][j]>max) {
                    max = array[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
                if (array[i][j]<min) {
                    min = array[i][j];
                    minRow = i;
                    minColumn = j;
                }

            }
        }

        System.out.println(max);
        System.out.println((maxRow + 1) + " "+ (maxColumn + 1));
        System.out.println(min);
        System.out.println((minRow + 1) + " "+ (minColumn + 1));





    }
}
