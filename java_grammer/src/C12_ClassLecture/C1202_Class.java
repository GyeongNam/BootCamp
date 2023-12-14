package C12_ClassLecture;

import java.util.Scanner;

public class C1202_Class {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(Calculator.sum(a,b));
//        System.out.println();

//        Calculator.sumAcc(10);
//        Calculator.sumAcc(20);
//        Calculator.sumAcc(30);
//        Calculator.sumAcc(40);
//        System.out.println(Calculator.memory1);

        Calculator cal1 = new Calculator();
        cal1.sumAcc(10);
        cal1.sumAcc(20);
        cal1.sumAcc(30);
        System.out.println(cal1.memory2);

        Calculator cal2 = new Calculator();
        cal2.sumAcc(40);
        cal2.sumAcc(50);
        cal2.sumAcc(60);
        System.out.println(cal2.memory2);
    }

}

class Calculator{
    static int memory1;
    int memory2;
    public int sum(int a, int b) {
        return a+b;
    }
    public int sub(int a, int b) {
        return a-b;
    }
    public int mul(int a, int b) {
        return a*b;
    }
    public int dvi(int a, int b) {
        return a/b;
    }

//    public static void sumAcc(int a) {
//        memory1 += a;
//    }
    public void sumAcc(int a) {
        // this는 객체 그 자신을 의미한다.
        this.memory2 += a;
    }
}
