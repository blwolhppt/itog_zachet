package ostalnoe;

import java.util.ArrayList;
import java.util.Collections;

public class task29 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            int elem = (int)(Math.random()*100) + 1;
            list.add(elem);
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < 10; i++){
            int elem = list.get(i);
            System.out.println(elem);
        }
    }
}