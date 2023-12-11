import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+ "\n");
        }
        bw.close();
//        String size = br.readLine();
//        int i = Integer.parseInt(br.readLine());
//        if(M < 45) {
//            H--;
//            M= 60 - (45 - M);
//            if(H < 0) {
//                H = 23;
//            }
//            System.out.println(H + " " + M);
//        }
//        else {
//            System.out.println(H + " " + (M - 45));
//        }

    }
}
