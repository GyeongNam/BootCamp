import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class C02_Variable {
//    public static void main(String[] args) {
//        byte num1 =127, num2 = -128;
//        num1++;
//        num2--;
//        System.out.println(num1);
//        System.out.println(num2);
//
//        float num3 = 1.123456789f;  // 8자리까지
//        double num4 = 1.123456789;  // 15자리까지
//
//        System.out.println("f : " + num3);
//        System.out.println("d : " + num4);
//
//        // 부동소수점 오차 테스트
//        double double_num = 0;
//
//        // 미세오차는 조정되어 정상적으로 출력
//        System.out.println(double_num);
//
//        // 반복적인 연산시 오차가 확대되어 오차 확인 가능
//        for (int i = 0; i<1000;  i++){
//            double_num = double_num + 0.1;
//        }
//        System.out.println( "천번찔린 0.1 = " + double_num);
//
//        System.out.println(0.1 + 0.1);
//        System.out.println(0.1 + 0.2);
//
//        // 오차 해결
//        double double_num2 = 0;
//        for (int i = 0; i<1000;  i++){
//            double_num2 = double_num2 + 0.1 * 10;
//        }
//        System.out.println( "천번찔린 0.1 ver2.0 = " + double_num2/10);
//
//        // BigDecimal : 저장할 때는 문자열 -> 연산할 때는 정수로 -> 최종 결과는 실수로 변환, 속도가 느리고 번거로움
//        BigDecimal myBig1 = new BigDecimal("1.03");
//        BigDecimal myBig2 = new BigDecimal("0.42");
//        System.out.println(myBig1.subtract(myBig2));
//
//        double result = myBig1.subtract(myBig2).doubleValue();
//        System.out.println(result);
//    }

//    public static void main(String[] args) {
//        char my_char = '가'; // utf-8
//        System.out.println(my_char);
//
//        // boolean : true(1) or false(0)
//        boolean my_bool = true;
//        System.out.println(my_bool);
//
//        if(my_bool){
//            System.out.println("조건식이 참입니다.");
//        }
//
//        int bool_num1 = 20, bool_num2 = 10;
//
//        if (bool_num1 > bool_num2){
//            System.out.println("조건식이 참입니다.");
//        }
//
//    }

//    public static void main(String[] args) {
//        // 묵시적 타입변환
//        char ch1 = 'a';
//        int ch1_num = (int)ch1;
//        System.out.println(ch1_num);
//
//        // cart형 알파벳 비교를 위한 묵시적 타입 변환
//        System.out.println('a'<'A');
//
//        int my_int1 = 10;
//        double my_double1 = my_int1;
//        System.out.println(my_double1);
//
//        // my_int1 = my_double1; 에러
//        // 명시적 타입 변환은 가능
//        my_int1 = (int)my_double1;
//        System.out.println(my_int1);
//
//        double my_double2 = 7.2f;
//        System.out.println(my_double2);
//
//        char my_char2 = 'b';
//        int char_num = (int)my_char2;
//
//        int a =1, b= 4, c = a/b;
//        double d = a/b;
//        System.out.println(c);
//        System.out.println(d);
//
//        double d2 = a/(double)b;
//        System.out.println(d2);
//    }

    public static void main(String[] args) {
        // 변수와 상수
        // 선언과 동시에 초기화
        int a1 = 10;

        // 변수값 변경
        a1 = 20;

        // 선언만 한 뒤에 나중에 초기화 (선언만 됐을 때는 값이 0으로 초기화 되지 않으나, 객채로 선언 됐을 때는 0으로 초기화)
        int a2;
        a2 = 20;

        int[] arr = new int[5];
        System.out.println(arr[0]);

        // 상수는 값의 재 할당이 불가능
        final int AGES = 20;
        // AGES = 30; 에러

        // 상수는 선언만 한 뒤에 나중에 초기화 하는 방식이 java8이후 가능해짐
        final int AGES2;
        AGES2 = 20;
        // AGES2 = 30; 에러
    }
}