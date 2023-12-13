import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
        solution(new int[]{1, 2, 3, 9, 10, 12});

    }

    public static int solution(int[] scoville) {
        int answer = -1;
        int k = 7;
//        int answer = 0;
//        int[][] dp = new int [triangle.length][];
//        for(int i = 0; i<triangle.length; i++){
//            dp[i] = new int[triangle[i].length];
//            for (int j = 0; j < triangle[i].length; j++) {
//                dp[i][j] += triangle[i][j];
////                dp[i+1][j] = dp[i][j] + triangle[i][j];
////                dp[i+1][j+1] = dp[i][j] + triangle[i][j];
//            }
//        }
//
//        for (int[] d:dp){
//            System.out.println(Arrays.toString(d));
//        }
//        System.out.println(answer);
        Queue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        for(int n : scoville){
            q.add(n);
        }

        for(int i = 0; i<q.size(); i++){
            if(q.peek()>k){
                break;
            }
            sum += q.poll() + q.poll() * 2;
            q.add(sum);
            answer++;
        }

        System.out.println(q.peek());

        System.out.println(answer);

        return answer;
    }


}

