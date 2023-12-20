package C13_Inheritance;

// util 하위의 모든 클래스 / 인터페이스 파일 import 가능
import java.util.*;
// 특정 패키지의 하위패키지의 모든 파일까지 import 하는 것은 불가능
// import java.*;

// final 클래스는 상속 불가
public class C1305_Others {
    public static void main(String[] args) {
        C1305_Dog d = new C1305_Dog();
        d.makeSound1();
        d.makeSound2();

        C1305_Animal a = new C1305_Animal() {
            @Override
            void makeSound1() {

            }
        };
        System.out.println(d.getClass());
        System.out.println(a.getClass());

    }
}

final class FinalClass{

}

abstract class C1305_Animal{
//    final void  makeSound(){
//        System.out.println("동물은 소리를 냅니다.");
//    }
    abstract void makeSound1();
    void  makeSound2(){
        System.out.println("동물은 소리를 냅니다.");
    }
}

class C1305_Dog extends C1305_Animal{
    // final 메서드는 오버라이딩 불가
//    @Override
//    void  makeSound(){
//        System.out.println("동물은 소리를 냅니다.");
//    }

    @Override
    void makeSound1() {

    }
}

