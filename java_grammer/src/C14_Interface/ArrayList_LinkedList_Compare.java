package C14_Interface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_LinkedList_Compare {
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(0,10);
        }
        long end_time = System.currentTimeMillis();
        System.out.println(end_time-start_time);

        long start_time2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.get(i);
        }
        long end_time2 = System.currentTimeMillis();
        System.out.println(end_time2-start_time2);
    }
}
