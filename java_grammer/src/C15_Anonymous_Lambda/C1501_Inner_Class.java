package C15_Anonymous_Lambda;

public class C1501_Inner_Class {

    public static void main(String[] args) {
        Member_Inner_Class.Static_Inner_Class si = new Member_Inner_Class.Static_Inner_Class();
        si.display();
    }
}

class Member_Inner_Class{
    private  int a;

    void display(){
        System.out.println("a의 값은"+a);
    }
    // static 내부 클래스
    // 이 클래스는 C1501_Inner_Class의 정적 맴버처럼 활용
    static class Static_Inner_Class{
        private  int data;

        void display(){
            System.out.println("data값은"+data+" 입니다.");
        }
    }
}

