package C15_Anonymous_Lambda;

public class C1503_Lambda_Expression {
    public static void main(String[] args) {
        // 실행문이 1줄 일때는 {} return 생략
        // 실행문이 2줄 이상일때에는 {} return 필요
        // 매개 변수를 순서로 인지하므로 타입을 지정해줄필요는 없다.

        Lambda_Interface li = (a, b, c) -> {
            String result = a+b;
            return  result;
        };
        System.out.println(li.makeString("이창선","심재혁",0));
    }
}

interface Lambda_Interface{
    String makeString(String a , String b, int c);
}
