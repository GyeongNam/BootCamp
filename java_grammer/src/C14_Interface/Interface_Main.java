package C14_Interface;

public class Interface_Main {
    public static void main(String[] args) {
        Cat_Implements ci = new Cat_Implements();
        ci.makeSound();
        Dog_Implements di = new Dog_Implements();
        di.makeSound();

        // 다형성이란 하나의 객체가 여러개의 참조 변수를 가질 수 있음을 의미
        Animal_Interface1 cmi = new Cat_Multi_Implements();
        cmi.makeSound();
        // 타입을 interface1 으로 선언 하면 interface2에 정의된 메서드는 사용 불가
        // System.out.println(cmi.play("이창선", "심재혁"));
        // 타입을 interface2 으로 선언 하면 interface1에 정의된 메서드는 사용 불가
        Animal_Interface2 dmi = new Dog_Multi_Implements();
        // dmi.makeSound();
        System.out.println(dmi.play("홍신애", "이창선"));

        // 기본적으로 추상클래스, 인터페이스는 객체 생성이 불가능하나 , 익명내부클래스 방시그옳 시용가능
        Animal_Interface1 ai = new Animal_Interface1() {
            @Override
            public void makeSound() {

            }
        };
    }
}
