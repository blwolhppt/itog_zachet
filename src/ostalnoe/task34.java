package ostalnoe;

import java.util.ArrayList;

public class task34 {
    public static void main(String[] args) {

        ArrayList<String> collect1 = new ArrayList<>();
        collect1.add("ольга");
        collect1.add("петр");
        collect1.add("сергей");
        collect1.add("наталья");

        for (String elem: collect1){
            System.out.println(elem);
        }
    }
}
