package C14_Interface;

public class Static_Final_Interface {
    public static void main(String[] args) {
        MyImplements a = new MyImplements();
        a.methodA();
        System.out.println(a.my_constant);
    }
}
interface MyInterface{
    // 아래 변수는 컴파일 타임에 static final 이 붙는다.
    int my_constant = 100;
    void  methodA();
}

class MyImplements implements MyInterface{

    @Override
    public void methodA() {
        System.out.println("MyImplements");
    }
}