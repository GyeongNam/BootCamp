import java.util.*;
import java.util.stream.Collectors;

public class C08_List {
//    public static void main(String[] args) {
//        // list 선언 방법
//        // ArrayList<String> list = new ArrayList<String>();
//        // 가장 흔한 방식으로 왼쪽엔 인터페이스, 오른쪽엔 구현체;
//        // ArrayList<String> list = new ArrayList<>();
//
//        ArrayList<String> list1 = new ArrayList<>();
//
//        // 초기값 생성 방법
//        list1.add("java");
//        list1.add("python");
//        list1.add("c++");
//        System.out.println(list1);
//
//        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("java, python, c++"));
//        System.out.println(list2);
//
//        String[] str = {"java", "python", "c++"};
//        ArrayList<String> list3 = new ArrayList<>(Arrays.asList(str));
//        System.out.println(list3);
//
//        // 배열이 int인 경우 -> 형변환 문제 발생
//        int[] myintarr = {1,2,3};
//        // List<Integer> myIntarr = new ArrayList<>(Arrays.asList(myintarr));
//        List<Integer> myIntarr = new ArrayList<>();
//        for (int i = 0; i < myintarr.length; i++) {
//            myIntarr.add(myintarr[i]);
//        }
//        System.out.println(myIntarr);
//
//
//    }

//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(10);
//        list.add(20);
//        // add(int index, int element) : 중간 삽입은 기본적으로 성능저하
//        list.add(1,13);
//        System.out.println(list);
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(30);
//        list2.add(40);
//        list2.add(50);
//
//        System.out.println(list2);
//        // addAll(Collection 객체) : 특정 리스트의 요소를 모두 add
//        list.addAll(list2);
//        System.out.println(list);
//
//        // get(int index) : 특정 위치의 요소를 반환
//        System.out.println(list.get(0));
//
//        // for 문 이용
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        for (int num : list){
//            System.out.println(num);
//        }
//
//        // remove : 요소 삭제
//        // remove는 value 삭제, index를 통한 삭제
//        list.remove(Integer.valueOf(13));
//        System.out.println(list);
//        // remove를 통한 index 삭제 : 0번째
//        list.remove(0);
//        System.out.println(list);
//
//        // set(int index , E element) : index 자리에 값 변경
//        list.set(list.size()-1, 100);
//        System.out.println(list);
//
//        // contains(E element) : 특정값이 있는지 없는지 boolean return
//        System.out.println(list.contains(30));
//
//        // indexOf : 몇 번째 index에 위치한지 return
//        // 같은 숫자가 있으면 첫번째 위치값 return
//        System.out.println(list.indexOf(30));
//
//        // clear() : 전체 삭제
//        list.clear();
//        System.out.println(list);
//
//        // isEmpty() : 비어있는지 확인
//        System.out.println(list.isEmpty());
//    }

//    public static void main(String[] args) {
//        List<int[]> list = new ArrayList<>();
//        int[] arr = {4,5,6};
//        list.add(arr);
//        list.add(new int[] {1,2,3});
//        list.add(new int[3]);
//        list.get(1)[0] = 10;
//        list.get(1)[1] = 20;
//
//        for (int[] a : list){
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println();
//        for (int i = 0; i<list.size(); i++){
//            System.out.println(Arrays.toString(list.get(i)));
//        }
//
//        List<List<Integer>> new_list = new ArrayList<>();
//        new_list.add(new ArrayList<>(new ArrayList<>()));
//        new_list.add(new ArrayList<>(new ArrayList<>()));
//        new_list.add(new ArrayList<>(new ArrayList<>()));
//        int count = 1;
//        for (int i = 0; i<new_list.size(); i++){
//            for (int j = 0; j<3; j++){
//                new_list.get(i).add( (j+1)*count );
//            }
//            count*=10;
//        }
//        System.out.println(new_list);
//    }

    public static void main(String[] args) {
        // list sort
        List<Integer> list = new ArrayList<>(Arrays.asList(5,3,2,1,5));

        // Collections.sort()
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, Comparator.reverseOrder());
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        // 객체.sort()
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        // String 배열을 list로 변환
        String[] str = {"str1","str2"};
        List<String> list1 = new ArrayList<>(Arrays.asList(str));
        List<String> list2 = new ArrayList<>(Arrays.asList("str3","str4"));
        List<String> list3 = new ArrayList<>();
        for (String s: str){
            list3.add(s);
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        // streamApi
        List<String> list4 = Arrays.stream(str).collect(Collectors.toList());
        System.out.println(list4);

        // int 배열을  list 전환
        // Arrays.asList() 사용불가
        // for문 담기 사용가능
        // streamApi 사용가능
        int[] int_arr = {10,20,30,40};
        List<Integer> list5 = Arrays.stream(int_arr).boxed().collect(Collectors.toList());
        System.out.println(list5);

        System.out.println();

        // String list => String array
        String[] new_Arr2 = new String[list3.size()];
        for (int i = 0; i < list3.size(); i++) {
            new_Arr2[i] = list3.get(i);
        }
        System.out.println(Arrays.toString(new_Arr2));

        String[] new_Arr1 = list3.stream().toArray(String[]::new);
        String[] new_Arr3 = list3.stream().toArray(a->new String[a]);
        System.out.println(Arrays.toString(new_Arr1));
        System.out.println(Arrays.toString(new_Arr3));

        System.out.println();
        int[] int_Arr1 = new int[list5.size()];
        for(int i = 0; i < list5.size(); i++){
            int_Arr1[i] = list5.get(i);
        }
        System.out.println(Arrays.toString(int_Arr1));
        int[] int_Arr2 = list5.stream().mapToInt(a->a).toArray();
        System.out.println(Arrays.toString(int_Arr2));


    }

}

