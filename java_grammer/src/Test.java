import java.io.*;
import java.util.*;

public class Test {
//    public static void main(String[] args) throws IOException {
//        solution(new int[][] {{7},{3,8},{8,1,0,},{2,7,4,4},{4, 5, 2, 6, 5}});
//    }
//
//    public static int solution(int[][] triangle) {
//        int answer = 0;
//
//        int[][] dp = new int [triangle.length][];
//        for(int i = 0; i<triangle.length; i++){
//            dp[i] = new int[triangle[i].length];
//            for (int j = 0; j < triangle[i].length; j++) {
//                dp[i][j] += triangle[i][j];
//            }
//        }
//
//        for(int i = 0; i<dp.length-1; i++){
//            for (int j = 0; j < triangle[i].length; j++) {
//                if(i == 0){
//                    dp[i+1][j] += dp[i][j];
//                    dp[i+1][j+1] += dp[i][j];
//                }else{
//                    if(dp[i+1][j] < dp[i][j] + triangle[i+1][j]){
//                        dp[i+1][j] = dp[i][j] + triangle[i+1][j];
//                    }
//                    dp[i+1][j+1] += dp[i][j];
//                }
//            }
//        }
//        answer = Arrays.stream(dp[dp.length-1]).max().getAsInt();
//        for (int[] d:triangle){
//            System.out.println(Arrays.toString(d));
//        }
//        for (int[] d:dp){
//            System.out.println(Arrays.toString(d));
//        }
//        System.out.println(answer);
//        return answer;
//    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long y = 0;
        int count = 0;
        long yu = sc.nextLong();
        long yd = sc.nextLong();
        long ye = sc.nextLong();
//        while (y<ye){
//            count++;
//            y += yu;
//            if(y >= ye){
//                break;
//            }
//            y -= yd;
//        }

        

        System.out.println(count);
    }
}

