package C13_Inheritance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class C1303_Method_Overriding {
    public static void main(String[] args) {
        // 상속 관계일 때 부모 클래스 타입을 자식 클래스 객체의 타입으로 지정 가능
        Animal d = new Dog();
        Cat c = new Cat();
        d.sound();
        // Animal 클래스에 정의된 매서드만 사용 가능하도록 제약이 발생
        // d.sound2();
        c.sound();
        List<String> list = new LinkedList<>();
    }
}
class Animal{
    void sound(){
        System.out.println("동물은 소리를 냅니다.");
    }

}
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
    void sound2(){
        System.out.println("동물은 소리를 냅니다.2");
    }
}
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("야옹");
    }
}