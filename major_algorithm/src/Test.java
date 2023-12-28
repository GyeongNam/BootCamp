import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();


//        st = new StringTokenizer(br.readLine());
//        int A = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        HashSet<String> set= new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i , j));
            }
        }
        System.out.println(set.size());
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
}
