import java.util.Scanner;

public class C05_LoopStatements {
//    public static void main(String[] args) {
//        int i = 2;
//        while (i<11){
//            System.out.println(i);
//            i++;
//        }
//    }

//    public static void main(String[] args) {
//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("구구단 단수를 입력해주세요");
//            int input1 = sc.nextInt();
//            int i = 1;
//            while (i < 10) {
//                System.out.println(
//                        input1 + " X " + i + " = " + (input1 * i)
//                );
//                i++;
//            }
//        }
//    }

//    public static void main(String[] args) {
//        String answer = "1234";
//
//        int i = 0;
//        while (i<5){
//            System.out.println("비밀번호를 입력해주세요.");
//            Scanner sc = new Scanner(System.in);
//            String input = sc.nextLine();
//            String result = input.equals(answer) ?
//                    "문이 열립니다."
//                    :
//                    "비밀번호가 틀렸습니다. 다시 입력해주세요.";
//            if(input.equals(answer)) {
//                System.out.println(result);
//                break;
//            }else{
//                System.out.println(result);
//            }
//            i++;
//        }
//    }

//    public static void main(String[] args) {
//        int i = 2;
//        do {
//            System.out.println(i);
//            i++;
//        }while (i<11);
//    }
//    public static void main(String[] args) {
//        for (int i = 0; i<10; i++){
//            if(i%2!=0){
//                System.out.println(i);
//            }else{
//                continue;
//            }
//        }
//    }

//    public static void main(String[] args) {
//        int num = 10;
//        if(num > 1){
//            int abc = 20;
//            num = 20;
//        }
//        System.out.println(num);
////        System.out.println(abc);  if 문 안에서 정의된 변수는 밖에서 인지 불가
//    }

//    public static void main(String[] args) {
//        for (int i = 2; i<10; i++){
//            System.out.println(i+"단 입니다.");
//            for (int j = 1; j<10; j++){
//                System.out.println(i + " X " + j + " = " + (i*j));
//            }
//        }
//    }

//    public static void main(String[] args) {
//        int[][] arr = {{1,2,4,5},{5,6,7,8}};
//        for(int i = 0; i<arr.length; i++){
//            for (int j = 0; j<arr[i].length; j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//    }

//    public static void main(String[] args) {
//        loop1:
//        for (int i = 0; i<5; i++){
//            loo2:
//            for (int j = 0; j<5; j++){
//                System.out.println("hello world");
//                if( j == 2){
//                    break ;
//                }
//            }
//        }
//    }

//    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4}, {5,6,7}, {8,9},{10,11,12,13,14}};
//        int targert = 11;
//        loop1:
//        for (int i = 0; i<matrix.length; i++){
//            loop2:
//            for (int j = 0; j<matrix[i].length; j++){
//                if(matrix[i][j] == targert){
//                    System.out.println("11을 찾아서 종료합니다. i = " + i + " j = " + j);
//                    break loop1;
//                }
//                System.out.println("i : " + i + ", j : " + j + " = " + matrix[i][j]);
//            }
//        }
//    }

    public static void main(String[] args) {
        int answer = 0;
        loop1 :
        for(int i = 1; i<=20; i++){
            int count = 0;
            System.out.println(i+"의 약수");
            loop2:
            for (int j = 1; j<=i; j++){
                if(i%j==0){
                    System.out.println(j);
                    count++;
                }
                if(count == 5){
                    answer = i;
                    break loop1;
                }
            }
            System.out.println("약수의 갯수 : "+ count);
        }
        System.out.println("answer : "+ answer);
    }
}

