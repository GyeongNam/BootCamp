import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.*;
public class C06_String {
//    public static void main(String[] args) {
//        // 참조 자료형: 기본 자료형을 제외한 모든 자료형
//        // Wrapper class : 키본형 타입에 없는 다양한 기능을 지원하기 위한 클래스
//
//        int a = 10;
//        Integer b = new Integer(20);
//
//        // 오토 언박싱
//        int c = b;
//
//        // 언박싱
//        int d = b.intValue();
//
//        // 오토 박싱
//        Integer e = a;
//
//        // 박싱
//        Integer f = Integer.valueOf(a);
//
//        // String과 int의 형변환
//        String str = Integer.toString(a);
//        c = Integer.parseInt(str);
//
//        // 참조 자료형에 원시 자료형을 담을 때는 Wrapper class를 써야한다.
//        List<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        System.out.println(list);
//    }

//    public static void main(String[] args) {
//        String str1 = new String("hello");
//        String str2 = new String("hello");
//        String str3 = "hello";
//        String str4 = "hello";
//        String str5 = str1;
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str3 == str4);
//        System.out.println(str1 == str5);
//
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.equals(str3));
//        System.out.println(str3.equals(str4));
//        System.out.println(str1.equals(str5));
//
//        List<String> list1 = new ArrayList<>();
//        List<String> list2 = list1;
//        list2.add("h2");
//        list1.add("h1");
//        System.out.println(list2);
//    }

//    public static void main(String[] args) {
//        // 문자열의 길이 : length()
//        String str = "hello";
//        System.out.println(str.length());
//
//        // 특정 문자열의 시작 위치 반환(가장 먼저 나오는 위치) : indexOf()
//        String str2 = "hello java";
//        System.out.println(str2.indexOf("java"));
//
//        // 특정 문자열이 있는지 확인 : contains()
//        System.out.println(str2.contains("java"));
//
//        // 특정 위치의 문자를 리턴 : charAt()
//        System.out.println(str2.charAt(0));
//
//        //charAt, length 를 활용한 문자a의 개수
//        String a = "qwerqweqwq";
//        int count = 0;
//        for(int i = 0; i<a.length(); i++){
//            if(a.charAt(i) == 'q'){
//                count++;
//            }
//        }
//        System.out.println(count);
//
//        String b = a.replaceAll("q","");
//        System.out.println( a.length()-b.length());
//
//        // 문자열을 자르는 : substring(a, b) a이상 b미만
//        String str1 = "hello world";
//        System.out.println(str1.substring(0,5));
//        System.out.println(str1.substring(6,str1.length()));
//
//        // 왼쪽, 오른쪽 공백 제거 : trim(), strip();
//        String trimSt = "      st    ";
//        String new_trim = trimSt.trim();
//        String new_strip = trimSt.strip();  // 자바 11부터
//        System.out.println(new_trim);
//        System.out.println(new_strip);
//    }

//    public static void main(String[] args) {
//        String a = "Hello";
//        String a1 = a.toUpperCase();
//        String a2 = a.toLowerCase();
//
//        System.out.println(a);
//        System.out.println(a1);
//        System.out.println(a2);
//
//        // 문자열 더하기는 + 사용
//        a += " world";
//        System.out.println(a);
//
//        char ch1 = 'a';
//        String st1 = Character.toString(ch1);
//
//        String str = "01abcABC123한글123";
//        String str2 = str.replaceAll("[a-z, A-Z]", "");
//        System.out.println(str2);
//
//        str2 = "";
//        for(int i = 0; i<str.length(); i++){
//            if(!(str.charAt(i)>='a' && str.charAt(i)<='z') && !(str.charAt(i)>='A' && str.charAt(i)<='Z')){
//                str2 += str.charAt(i);
//            }
//        }
//        System.out.println(str2);
//
//        // 문자열중에 특정문자열을 바꿔 새로운 문자열을 반환 : replace(), replaceAll()
//        // [a-z, A-Z, 가-힣, 0-9]
//        st1 = "hello world";
//        String st2 = st1.replace("world", "java");
//        System.out.println(st2);
//
//        String st3 = st1.replaceAll("world", "python");
//        System.out.println(st3);
//    }

    public static void main(String[] args) {
        // Pattern 클래스
        boolean matcher = Pattern.matches(".*[a-z]*.+", "helloworld");
        System.out.println(matcher);

        boolean matcher2 = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", "010-1234-1234");
        System.out.println(matcher2);

        boolean matcher3 = Pattern.matches("^[a-z,0-9]+@[a-z]+.com$", "hello@naver.com");
        System.out.println(matcher3);

        // 문자열 나누기 : split()
        String a = "a:b:c:d";
        String[] starr = a.split(":");
        System.out.println(Arrays.toString(starr));

        String b = " a  b c d";
        String[] starr2 = b.split(" ");
        System.out.println(Arrays.toString(starr2));

        String[] starr3 = b.trim().split("\\s+");
        System.out.println(Arrays.toString(starr3));

        // isEmpty와 null 구분
        String st1 = null;
        String st2 = "";

        System.out.println(st1==null);
        System.out.println(st2==null);
        System.out.println(st2.isEmpty());
        // System.out.println(st1.isEmpty()); // NullPointerException

        String[] arr = new String[5];
        arr[0] = "hello";
        arr[1] = "hello";
        System.out.println(Arrays.toString(arr));

        String[] sarr = {"a","b","c"};
        System.out.println(String.join(",", sarr));

        // String과 int의 형변환
        int a1 = 0;
        String a1_str1 = Integer.toString(a1);
        String a1_str2 = String.valueOf(a1);
        System.out.println(a1_str1);
        System.out.println(a1_str2);

        // 문저열을 추가하거나 변경할 떼 주로 사용하는 객체 : StringBuffer
        // append , insert, substring, delete, StringBuilder
        StringBuffer str = new StringBuffer("hello");
        System.out.println(str);

        str.append(" world");   // +=
        System.out.println(str);

        str.insert( 6,"java ");
        System.out.println(str);

        System.out.println(str.substring(6, 10));
        System.out.println(str.delete(6,10));

        StringBuilder str2 = new StringBuilder("hello");
        str2.append(" world");
        System.out.println(str2);


    }

}
