import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.logging.Logger.global;

public class Test {
//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("hello");
//        System.out.println(list);
//
//        int a = 10;
//        test(a);
//        System.out.println(a);
//        test(list);
//        System.out.println(list);
//    }
//    static void test(int a){
//        a += 10;
//    }
//    static void test(List list){
//        list.add("hell02");
//    }

//    int search = sc.nextInt();
//    int size = sc.nextInt();
//    int[] arr = new int[size];
//        for (int i = 0; i < arr.length; i++) {
//        arr[i] = sc.nextInt();
//    }
    public static void main(String[] args) throws IOException {
        System.out.println("1번");
        solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("2번");
        solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("3번");
        solution(new int[]{0, 0, 5, 5, 5}, 2);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        TreeSet<Integer> set = new TreeSet<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                }
        );

        for(int n : scoville){
            set.add(n);
        }
        System.out.println(set);
        while (set.first() < K){
            if(set.size() == 1){
                return -1;
            }
            set.add(set.first() + set.higher(set.first())*2);
            set.remove(set.first());
            set.remove(set.first());
            answer++;
        }
        System.out.println(answer);
        System.out.println();
        return answer;
    }


}

