package C12_ClassLecture;

public class C1206_Recursive_Basic {
    public static void main(String[] args) {
////        for문을 이용해서 1~10까지 누적합계
//        int sum =0;
//        for(int i = 10; i >= 1; i--){
//            sum += i;
//        }
////        System.out.println(sum);
////        System.out.println(add_acc(10));
//
////      누적곱하기 값 : 팩토리얼, 10*9*8*,,,*1
//        System.out.println(factorial(5));

////      for문을 활용한 피보니치 수열 (배열 없이)
//        int[] fibonacchi1 = new int [10];
//        int first = 1;
//        int second = 1;
//        for(int i = 2; i < 10; i++){
//            int third = first + second;
//            first = second;
//            second = third;
//            System.out.print(third + " ");
//        }
//
//        System.out.println(fibonacci(10));

////        배열을 이용한 피보나치 수열
////        메모이제이션(기억알고리즘 - DP)
//        int[] fibonacchi = new int [10];
//        for(int i = 0; i < 10; i++){
//            if(i == 0 || i == 1){
//                fibonacchi[i] = 1;
//            }
//            else {
//                fibonacchi[i] = fibonacchi[i-2] + fibonacchi[i-1];
//            }
//        }
//        System.out.println(Arrays.toString(fibonacchi));

//        System.out.println(fibonacci(9));
    }
////    메소드가 자기자신을 호출하는 메서드를 재귀함수라 한다. 이러한 호출방식을 재귀호출이라고 한다.
//    static int add_acc(int n){
//        if(n == 1){
//            return 1;
//        }
//        return n + add_acc(n-1);
//    }
//
//    static int factorial(int n){
//        if(n == 1){
//            return 1;
//        }
//        return  n * factorial(n-1);
//    }

//    fibonacci 재귀함수
    static int fibonacci (int n){
        if(n <= 1){
            return  1;
        } else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}