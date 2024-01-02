import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Stack<Integer> stack = new Stack<>();
//        Queue<Integer> queue = new LinkedList<>();
//        int size = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < size ; i++) {
//            queue.offer(Integer.parseInt(st.nextToken()));
//        }
//        int index = 1;
//        while (!queue.isEmpty()){
//            if(queue.peek() == index){
//                queue.poll();
//                index++;
//            }else if (!stack.isEmpty() && stack.peek() == index){
//                stack.pop();
//                index++;
//            }else{
//                stack.push(queue.poll());
//            }
//        }
//        while (!stack.isEmpty()){
//            if(stack.peek() == index){
//                stack.pop();
//                index++;
//            }else{
//                System.out.println("Sad");
//                return;
//            }
//        }
//        System.out.println("Nice");

        solution(new int[][]{{0,3},{1,9},{2,6}});

    }

    public static long solution(int[][] jobs) {
        int answer = 0;
        int end = 0;
        int jobsIdx = 0;
        int count = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (count < jobs.length) {
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }

            if (pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        answer = (int) Math.floor((double) answer / jobs.length);
        System.out.println(answer);
        return answer;
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
