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
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st;
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        HashSet<String> set = new HashSet<>();
//
//        int N = Integer.parseInt(st.nextToken());
////        int M = Integer.parseInt(st.nextToken());
//        for (int i = 0; i < N; i++) {
//            String[] str = br.readLine().split(" ");
//            if(str[1].equals("enter")){
//                set.add(str[0]);
//            }else if(str[1].equals("leave")){
//                set.remove(str[0]);
//            }
//        }
//        set.stream().sorted((o1, o2) -> o2.compareTo(o1)).forEach(System.out::println);


//        int count = 0;
//        for (int i = 0; i < M; i++) {
//            if (set.contains(br.readLine())){
//                count++;
//            }
//        }
//        System.out.println(count);


//        System.out.println(Arrays.toString(new_arr));
//        System.out.println(Arrays.toString(arr2));




//        int[] new_arr = arr.clone();
//        Arrays.sort(new_arr);
//        int index=0;
//
//        for(int i=0; i<N; i++) {
//            if(!map.containsKey(new_arr[i]))
//                map.put(new_arr[i], index++);
//        }
//
//        for(int i=0; i<N; i++){
//            sb.append(map.get(arr[i])).append(" ");
//        }
//
//        System.out.print(sb);


//        for (String[] l :arr){
//            System.out.println(l[0] + " "+ l[1]);
//        }




//        System.out.println(x_max-x_min+" "+y);


//        Scanner sc = new Scanner(System.in);
        solution(2,9);
        solution(2,1);
        solution(2,8);

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


    public static int[] solution(int n, int s) {
        if(n>s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        for(int i=0; i<answer.length; i++){
            answer[i] = s/n;
        }
        int idx = n - 1;
        for(int i=0; i<s%n; i++){
            answer[idx] ++;
            idx--;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }



//    public static void bfs(int[][] maps, boolean[][] visited, int i){
//        System.out.println();
//        for (int j = i; j < maps.length; j++) {
//            if(visited[i][j]){
//                visited[i][j] = true;
//                bfs(maps, visited, j);
//                visited[i][j] = false;
//            }
//        }
//    }
}

