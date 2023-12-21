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
        String str = sc.nextLine();
        int str_length = str.length();

        int N = Integer.parseInt(str);
        int result = 0;

        for(int i = (N - (str_length * 9)); i < N; i++) {
            int number = i;
            int sum = 0;
            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }
            if(sum + i == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);





//        System.out.println(x_max-x_min+" "+y);


//        Scanner sc = new Scanner(System.in);
//        solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}});
//        solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}});

    }
    public static boolean isPrime(int num) {
        boolean result = true;
        if(num == 1){
            result = false;
        }
        for(int i = 2; i < num; i++) {
            if( num%i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }


    public static int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][];
        for (int i = 0; i<maps.length; i++){
            visited[i]  = new boolean[maps[i].length];
        }

        bfs(maps, visited , 0 );


        System.out.println(answer);
        return answer;
    }

    public static void bfs(int[][] maps, boolean[][] visited, int i){
        System.out.println();
        for (int j = i; j < maps.length; j++) {
            if(visited[i][j]){
                visited[i][j] = true;
                bfs(maps, visited, j);
                visited[i][j] = false;
            }
        }
    }
}

