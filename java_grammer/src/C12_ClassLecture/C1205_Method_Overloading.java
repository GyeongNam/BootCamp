package C12_ClassLecture;

import java.util.ArrayList;
import java.util.List;

public class C1205_Method_Overloading {
    public static void main(String[] args) {

        C1205_Method_Overloading mto = new C1205_Method_Overloading();
//        메서드 오버로딩을 통해 같은 메서드명 재활용
        System.out.println(mto.sum(10 ,20));
        System.out.println(mto.sum(10 ,20, 30));
        System.out.println(mto.sum(20.5, 30));

//        제네릭을 통해 타입재활용
        List<Integer> myList = new ArrayList<>();
    }
//    int 두 개를 매개변수로 받아서 더한 값 return 메서드
    public int sum(int a, int b){
        return a+b;
    }
    public double sum(double a, double b){
        return a+b;
    }

//    int 세 개를 매개변수로 받아서 더한 값 return 메서드
    public int sum(int a, int b, int c){
        return a+b+c;
    }
}