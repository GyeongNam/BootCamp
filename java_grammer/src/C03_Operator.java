

public class C03_Operator {
    public static void main(String[] args) {
        int num1 = 8, num2 = 3;
        // * , / , %
        System.out.println("num1 + num2 = "+ (num1+num2));
        System.out.println("num1 - num2 = "+ (num1-num2));
        System.out.println("num1 * num2 = "+ (num1*num2));
        System.out.println("num1 / num2 = "+ (num1/(double)num2));
        System.out.println("num1 % num2 = "+ (num1%num2));

        // 대입 연산자
        int n1 = 7, n2 = 7, n3 = 7;
        n1 = n1-3;
        n2 -= 3;
        n3 =- 3;

        int n4 = 10, n5 = 10;
        n4 /= 3;
        n5 %= 3;
        System.out.println(n4);
        System.out.println(n5);

        // 증감연산자
        int a = 5;
        int b = a++;
        System.out.println(a);
        System.out.println(b);

        a = 5;
        b = ++a;
        System.out.println(a);
        System.out.println(b);

        int[] arr = {10,20,30};
        a = 0;
        for(int ar : arr){
            System.out.println(arr[a]);
            a++;
        }
        char char1 = 'a' , char2 = 'A';
        System.out.println(char1 == char2);
        System.out.println(char1 != char2);

        // 논리연산자 &&, ||, !
        int num01 = 10, num02 = 20;
        boolean result1, result2;
        result1 = 5<num01 && num01<20;
        result2 = 10<num02 || num02<30;
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(!result2);

        //  비트연산자  & 각자리리의 수가 모두 1일 경우만 1
        System.out.println(2 & 1);
        System.out.println(2>0 & 3>0);

        n1 = 10;
        n2 = 20;

        if(n1>20 & n2<30){
            System.out.println("조건은 참입니다.");
        }

        // & | ^ ~
        n1 = 5; // 0101
        n2 = 6; // 0110
        System.out.println(n1 & n2);    // 4 = 0100
        System.out.println(n1 | n2);    // 7 = 0111
        System.out.println(n1 ^ n2);    // 3 = 0011
        System.out.println(~n1);        // 첫째자리가 음/양인데, 음으로 변환

        // << >> , 곱셈과 나눗셈의 효과
        System.out.println(n1 << 1);
        System.out.println(n2 >> 1);

        a = 13; // 01101
        b = 9;  // 01001

        while (b != 0){
            int same_index = a & b;
            a = a ^ b;
            b = same_index << 1;
        }
        System.out.println(a);

    }
}
