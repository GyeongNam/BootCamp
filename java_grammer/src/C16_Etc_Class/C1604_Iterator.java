package C16_Etc_Class;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C1604_Iterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        for(String str : list){
            System.out.println(str);
        }
        System.out.println();

        Iterator<String> is = list.iterator();
        while(is.hasNext()){
            // System.out.println(is.next());
            if(is.next().equals("banana")){
                is.remove();
            }
        }

        System.out.println(list);

    }
}
