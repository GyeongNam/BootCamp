import java.io.*;
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
        solution(new int[][] {{7},{3,8},{8,1,0,},{2,7,4,4},{4, 5, 2, 6, 5}});
    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int [triangle.length][];
        for(int i = 0; i<triangle.length; i++){
            dp[i] = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] += triangle[i][j];
            }
        }

        for(int i = 0; i<dp.length-1; i++){
            for (int j = 0; j < triangle[i].length; j++) {
                if(i == 0){
                    dp[i+1][j] += dp[i][j];
                    dp[i+1][j+1] += dp[i][j];
                }else{
                    if(dp[i+1][j] < dp[i][j] + triangle[i+1][j]){
                        dp[i+1][j] = dp[i][j] + triangle[i+1][j];
                    }
                    dp[i+1][j+1] += dp[i][j];
                }
            }
        }
        answer = Arrays.stream(dp[dp.length-1]).max().getAsInt();
        for (int[] d:triangle){
            System.out.println(Arrays.toString(d));
        }
        for (int[] d:dp){
            System.out.println(Arrays.toString(d));
        }
        System.out.println(answer);
        return answer;
    }

//    public static boolean solution(String s) {

//    }


}

