package C17_Exception_File_Parsing;

import java.util.Scanner;

public class C1701_Exception {
    public static void main(String[] args) {
        System.out.println("나눗셈 프로그램입니다. 숫자에 10에 나눌 분모값을 입력해주세요");
        int num = 10;
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        // 예외가 발생할 것으로 예상되는 코드에 try catch로 감싸준다.
        try {
            System.out.println("10에"+input+"을 나누면"+num/input+"입니다.");
            // catch에는 try 구문안에서 발생가능한 예외사항을 적어야 정상적으로 catch가 된다.
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        catch (ArithmeticException e){
            // e안에 예외관련된 정보들이 들어있음.
            System.out.println("예외가 발생했습니다.");
            e.printStackTrace();
        }finally {
            // 반드시 실행되어야 하는 구문 삽입
        }
        System.out.println("감사합니다.");

        // throw와 throws 예제
        /*
        * unchecked exception 에서 throws 를 하지 않더라도 예외는 호출한 곳으로 전파
        * 이때에 throws 를 하는 이유는 명시적으로 예외가 발생할 수 있음을 알리는 것일 뿐.
        *
        * checked exception 은 예외처리가 강제되고, 해당 메서드에서 예외처리를 하든지 throws 통해 호출한 곳에 위임
        * 이때 호출한 쪽에서는 예외처리가 강제된다.
        */
        String pwd = "1234";
        try {
            login(pwd);
        } catch (IllegalAccessException e) {
            // e.getMessage()는 login 메서드에서 throw new 한 곳에서 넘어온 메시지
            System.out.println(e.getMessage());
        }

    }
    static void login(String pwd) throws IllegalAccessException{
        if(pwd.length()<10){
            throw  new IllegalAccessException("비밀번호가 너무 짧습니다.");
        }
    }
}
