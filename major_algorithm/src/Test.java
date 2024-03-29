import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st; // = new StringTokenizer(br.readLine());
        HashSet<Integer> list = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            if(list.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);

//        solution(new int[] {180, 5000, 10, 600}, new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
//        solution(new int[] {120, 0, 60, 591}, new String[] {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
//        solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"});

    }
    static int factorial(int N) {
        // factorial(0) == 1 이다.
        if (N <= 1)	{
            return 1;
        }
        return N * factorial(N - 1);
    }

    public static long[] solution(int[] fees, String[] records) {

        Map<String, List<Long>> map = new HashMap<>();
        Map<String, String> timeList = new HashMap<>();

        for(String str : records){
            String[] strArr = str.split(" ");
            if(strArr[2].equals("IN")){
                timeList.put(strArr[1] , strArr[0]);
            }else{
                LocalTime start = LocalTime.parse(timeList.get(strArr[1]));
                LocalTime end = LocalTime.parse(strArr[0]);
                List<Long> list = new ArrayList<>();
                if(map.containsKey(strArr[1])){
                    map.get(strArr[1]).add(Duration.between(start, end).toMinutes());
                }else{
                    list.add(Duration.between(start, end).toMinutes());
                    map.put(strArr[1], list);
                }
                timeList.remove(strArr[1]);
            }
        }
        // 00시 넘어가는것들 처리
        for( Map.Entry<String, String> entry : timeList.entrySet() ){
            String strKey = entry.getKey();
            LocalTime start = LocalTime.parse(timeList.get(strKey));
            LocalTime end = LocalTime.parse("23:59");
            List<Long> list = new ArrayList<>();
            if(map.containsKey(strKey)){
                map.get(strKey).add(Duration.between(start, end).toMinutes());
            }else{
                list.add(Duration.between(start, end).toMinutes());
                map.put(strKey, list);
            }
        }
        long[] answer = new long[map.size()];
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        int index = 0;
        for (String key : keySet) {
            List<Long> lists = map.get(key);
            long num = 0;
            for (long a : lists){
                num += a;
            }

            if(fees[0]<num){
                answer[index] = fees[1] + (long)Math.ceil((((double) num-fees[0])/(double)fees[2])) * fees[3];
            }else{
                answer[index] = fees[1];
            }
            index++;
        }
        System.out.println(Arrays.toString(answer));
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
