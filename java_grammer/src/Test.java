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
        Map<Integer, Integer> mapx = new HashMap<>();
        Map<Integer, Integer> mapy = new HashMap<>();
        int x = 0,y = 0;
        int size = sc.nextInt();
        for (int i = 0; i<size; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            mapx.put(x, mapx.getOrDefault(x, 0)+1);
            mapy.put(y, mapy.getOrDefault(y, 0)+1);
        }
        int x_min = x;
        int x_max = x;
        int y_min = y;
        int y_max = y;

        for (Map.Entry<Integer, Integer> entry : mapx.entrySet()) {
            if(entry.getKey() > x_max ){
                x_max = entry.getKey();
            }
            if(entry.getKey() < x_min){
                x_min = entry.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> entry : mapy.entrySet()) {
            if(entry.getKey() > y_max ){
                y_max = entry.getKey();
            }
            if(entry.getKey() < y_min){
                y_min = entry.getKey();
            }
        }
        System.out.println((x_max-x_min)*(y_max-y_min));
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

