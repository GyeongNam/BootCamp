package C13_Inheritance;

// super(); = 부모클래스의 생성자 의미
// super 키워드 = 부모클래스 의미;
public class C1302_SuperChildClass extends SuperParents{
    int b;
    int a;
    C1302_SuperChildClass(){
        super(100);
        this.a = 30;
        this.b = 20;
    }
    void  display(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(super.a);
    }
    public static void main(String[] args) {
        C1302_SuperChildClass sc = new C1302_SuperChildClass();
        sc.display();
        sc.display2();
    }

}

class SuperParents{
    int a;
    SuperParents(int a){
        this.a = a;
    }

    void display2(){
        System.out.println("부모 디스플레이");
    }
}