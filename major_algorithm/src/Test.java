import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size ; i++) {

        }



//        solution(new int[] {2, 3, 3, 5});
//        solution(new int[] {9, 1, 5, 3, 6, 2});



    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        return answer;
    }
    static private boolean convert(String word1, String word2){
        int diffCnt = 0;
        for (int i = 0; i<word1.length(); i++){
            if (word1.charAt(i) != word2.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }


    static long gcd ( long a, long b){
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            long temp2 = a % b;
            a = b;
            b = temp2;
        }
        return a;
    }

    static boolean isPrime ( long n){
        for (long i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void bfs (ArrayList < List < Integer >> list,boolean[] visited, int[] distance, int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int target : list.get(next)) {
                if (!visited[target]) {
                    visited[target] = true;
                    distance[target] = distance[next] + 1;
                    queue.add(target);
                }
            }
        }
    }

}
