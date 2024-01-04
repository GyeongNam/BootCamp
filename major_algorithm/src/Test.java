import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int i, j = 1;
        for (i = 1; i < a; i++) {
            if (a == 1) {
                System.out.println(i);
            }
            a -= i;
        }
        if ((i % 2) == 0) {
            a--;
            while (a != 0) {
                i--;
                j++;
                a--;
            }
            System.out.println(j+ "/" + i);
        }
        else {
            a = i - a;
            while (a != 0) {
                i--;
                j++;
                a--;
            }
            System.out.println(j+ "/" + i);
        }

//        solution("hit","cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
//        solution("hit","cog", new String[] {"hot", "dot", "dog", "lot", "log"});

    }

    public static long solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>(); // 변환 가능한 단어들을 저장할 queue
        Set<String> set = new HashSet<>(Arrays.asList(words));
        if(!set.contains(target)){
            return 0;
        }
        q.offer(begin);
        set.remove(begin);
        while (!q.isEmpty()){
            for (int i=0; i<q.size(); i++){
                String temp = q.poll();
                if (temp.equals(target)){
                    return answer; // 타겟 단어에 도달
                }
                for (String word : set.toArray(new String[set.size()])){
                    if(convert(temp,word)){
                        q.offer(word);
                        set.remove(word);
                    }
                }
            }
            answer++;
        }
        return 0;
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
