import java.util.*;

public class C09_Map {
    public static void main(String[] args) {
        // map
        Map<String,String> map = new HashMap<>();
        map.put("basketball","농구");
        map.put("soccer","축구");
        map.put("baseball","야구");
        System.out.println(map);
        System.out.println(map.get("basketball"));

        // size() , isEmpty() 사용가능
        // 이미 key가 있을경우 put을 하면 덮어쓰기
        map.put("basketball","탁구");

        // 없으면 put putIfAbsent
        map.putIfAbsent("basketball","배구");

        // getOrDefault : key가 없으면 default 값 return
        System.out.println(map.getOrDefault("tennis", "스포츠"));

        System.out.println(map.containsKey("tennis"));

        map.remove("basketball");

        System.out.println(map.keySet());
        System.out.println(map.values());

        int total = 0;
        for(String a : map.keySet()){
            System.out.println(a);
        }

        System.out.println();

        // Iterator 를 통해 key값 하나씩 출력.
        Iterator <String> iter = map.keySet().iterator();
        // next() 메서드는 데이터를 소모시키면서 return
        System.out.println(iter.next());
        // hasNext() : 값이 있는지 없는지
        System.out.println(iter.hasNext());

        System.out.println();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println();
        List<String> list2 = new ArrayList<>();
        list2.add("basketball");
        list2.add("basketball");
        list2.add("basketball");
        list2.add("baseball");
        list2.add("baseball");
        list2.add("tennis");
        list2.add("tennis");
        list2.add("tennis");

        Map<String,Integer> map2 = new HashMap<>();
        for(int i = 0; i< list2.size(); i++){
            map2.put(list2.get(i), map2.getOrDefault(list2.get(i), 0)+1);
        }
        System.out.println(map2);
        for(String key : map2.keySet()){
            System.out.println(key+" 인원은 "+ map2.get(key)+"명 입니다.");
        }


    }

}
