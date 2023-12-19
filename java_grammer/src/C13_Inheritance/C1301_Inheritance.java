package C13_Inheritance;

// extends 를 통해 상속관계를 표현
public class C1301_Inheritance extends Parents {
    int c = 30;
    public static void main(String[] args) {
        C1301_Inheritance ih = new C1301_Inheritance();
        System.out.println(ih.c);
        System.out.println(ih.a);
        ih.parentMethod();
        ih.childMethod();

    }
    void childMethod(){
        System.out.println("자식 클래스 입니다.");
    }
    // 부모 클래스의 메서드 명을 동일하게 사용함으로서 메소드 오버라이딩(덮어쓰기)했다.
    @Override
    void parentMethod(){
        System.out.println("부모 클래스가 아니라 자식 클래스 입니다.");
    }
}
class Parents {
    int a = 10;
    private int b = 20; // 자식 클래스에서 접근이 불가능하다.

    void parentMethod(){
        System.out.println("부모 클래스 입니다.");
    }

}