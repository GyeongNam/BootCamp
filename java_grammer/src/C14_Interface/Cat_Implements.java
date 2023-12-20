package C14_Interface;

public class Cat_Implements implements Animal_Interface1{
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}

class Cat_Multi_Implements implements  Animal_Interface1, Animal_Interface2{

    @Override
    public void makeSound() {
        System.out.println("야옹");
    }

    @Override
    public String play(String a, String b) {
        return a+"와 "+b+"가 놉니다.";
    }
}
