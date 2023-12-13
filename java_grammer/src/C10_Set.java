import java.util.*;

public class C10_Set {
//    public static void main(String[] args) {
//        Set<String> mySet = new HashSet<>();
//        mySet.add("h");
//        mySet.add("h");
//        mySet.add("e");
//        mySet.add("l");
//        mySet.add("l");
//        mySet.add("l");
//        mySet.add("o");
//    }

    public static void main(String[] args) {
        // 반 학생들이 좋아하는 운동 종목 : list로 만들고
        // 좋아하는 종목만 추리도록 set으로 변환

        List<String> list = new ArrayList<>();
        list.add("basketball");
        list.add("basketball");
        list.add("basketball");
        list.add("baseball");
        list.add("baseball");
        list.add("tennis");
        list.add("tennis");
        list.add("tennis");

        Set<String> mySet = new HashSet<>();
        //Set<String> mySet = new HashSet<>(list); list를 인자값으로 받아 한줄 처리 가능

        mySet.addAll(list);
        System.out.println(mySet.size());

        System.out.println(list.stream().distinct().count());

        // 배열을 인자값으로 받아 set초기 세팅
        String[] arr = {"java", "python","c++", "java", "python" };
        Set<String> mySet2 = new HashSet<>(Arrays.asList(arr));
        System.out.println(mySet2);

        mySet2.remove("java");
        System.out.println(mySet2);

        Set<String> mySet3 = new HashSet<>(Arrays.asList("java", "python", "js"));
        Set<String> mySet4 = new HashSet<>(Arrays.asList("java", "html", "css"));

        // 교집합 retainAll
        Set<String> temp1 = new HashSet<>(mySet3);
        temp1.retainAll(mySet4);
        System.out.println(temp1);

        // 합집합 addAll
        Set<String> temp2 = new HashSet<>(mySet3);
        temp1.addAll(mySet4);
        System.out.println(temp2);

        // 차집합 removeAll
        Set<String> temp3 = new HashSet<>(mySet3);
        temp1.removeAll(mySet4);
        System.out.println(temp3);

        // LinkedHashSet m TreeSet
        Set<String> mySet5 = new TreeSet<>();
        mySet5.add("hello5");
        mySet5.add("hello4");
        mySet5.add("hello3");
        mySet5.add("hello2");
        mySet5.add("hello1");
        System.out.println(mySet5);

        // 두개 뽑아서 더하기
        int[] num ={2,1,3,4,1};
        Set<Integer> mytset = new TreeSet<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                mytset.add(num[i]+num[j]);
            }
        }
        int[] answer = new int[mytset.size()];
        Iterator<Integer> iter = mytset.iterator();
        for (int i = 0; i < mytset.size(); i++) {
            answer[i] = iter.next();
        }
        System.out.println(Arrays.toString(answer));


    }
}
