package C14_Interface;

public class Dog_Implements implements Animal_Interface1 {

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}
class Dog_Multi_Implements implements  Animal_Interface1, Animal_Interface2{

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }

    @Override
    public String play(String a, String b) {
        return a+"와 "+b+"가 놉니다.";
    }
}