import java.util.*;
public class C08_List {
    public static void main(String[] args) {
        // list 선언 방법
        // ArrayList<String> list = new ArrayList<String>();
        // 가장 흔한 방식으로 왼쪽엔 인터페이스, 오른쪽엔 구현체;
        // ArrayList<String> list = new ArrayList<>();

        ArrayList<String> list1 = new ArrayList<>();

        // 초기값 생성 방법
        list1.add("java");
        list1.add("python");
        list1.add("c++");
        System.out.println(list1);

        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("java, python, c++"));
        System.out.println(list2);

        String[] str = {"java", "python", "c++"};
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList(str));
        System.out.println(list3);

        // 배열이 int인 경우 -> 형변환 문제 발생
        int[] myintarr = {1,2,3};
        // List<Integer> myIntarr = new ArrayList<>(Arrays.asList(myintarr));
        List<Integer> myIntarr = new ArrayList<>();
        for (int i = 0; i < myintarr.length; i++) {
            myIntarr.add(myintarr[i]);
        }
        System.out.println(myIntarr);


    }
}
