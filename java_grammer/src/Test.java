import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        System.out.println(list);

        int a = 10;
        test(a);
        System.out.println(a);
        test(list);
        System.out.println(list);
    }
    static void test(int a){
        a += 10;
    }
    static void test(List list){
        list.add("hell02");
    }
}
