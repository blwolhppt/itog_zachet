package sql.excel;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class  c {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String test;
        ArrayList<String> st_st = new ArrayList<String>();

        for(int i=0;i<5;i++) {
            test = in.nextLine();
            st_st.add((String) test);
        }

        System.out.println(st_st);
    }
}