import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
        Scanner sc = new Scanner(System.in);
        int x_size = sc.nextInt();
        int y_size = sc.nextInt();
        int[][] arr = new int[x_size][y_size];
        for(int i = 0; i<x_size; i++){
            for (int j = 0; j < y_size; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i<x_size; i++){
            for (int j = 0; j < y_size; j++) {
                arr[i][j] += sc.nextInt();
            }
        }
        for (int[] num :arr){
            for(int n : num){
                System.out.println(n);
            }
        }
    }
}

