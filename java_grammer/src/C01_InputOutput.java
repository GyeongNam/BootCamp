import java.util.Scanner;

public class C01_InputOutput {
    public static void main(String[] args) {
        // 출력
        int a = 20;
        System.out.print(a);
        String my_str = "hello world";

        // 문자열 + 숫자 = 문자열
        System.out.println(my_str + a);

        // 숫자와 숫자를 더하면 더하기 연산이 된다.
        System.out.println(10+20);

        // 입력 : System,in(키보드입력) + Scanner(입력을 위한 클래스)
        Scanner myScan = new Scanner(System.in);
        System.out.println("아무 문자열을 입력해주세요");

        // nextLine은 입력받은 데이터를 한 줄 읽어서 String으로 변환
        String inputs = myScan.nextLine();
        System.out.println("사용자가 입력한 문자열 : " + inputs);

        // nextInt은 입력받은 데이터를 한 줄 읽어서 int으로 변환
        int inputs_int = myScan.nextInt();
        System.out.println("사용자가 입력한 숫자 : " + inputs_int);

        // 입출력 시스템 메모리 해제
        myScan.close();

    }

//    public static void main(String[] args) {
//        Scanner myScan = new Scanner(System.in);
//        System.out.println("더하기를 할 숫자 2개를 입력해주세요.");
//        int a = myScan.nextInt();
//        int b = myScan.nextInt();
//        System.out.println("입력하신 두 수를 더한 값은 : "+ (a+b));
//    }

//    public static void main(String[] args) {
//        Scanner myScan = new Scanner(System.in);
//        System.out.println("실수를 입력해 주세요.");
//        double a = myScan.nextDouble();
//        System.out.println(a);
//        System.out.println("boolean 입력.");
//        boolean b = myScan.nextBoolean();
//        System.out.println(b);
//    }
}

