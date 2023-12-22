package C15_Anonymous_Lambda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C1505_SteamAPI {
    public static void main(String[] args) {
        int[] arr = {20, 10, 4, 12};
        // 데이터와 객체 중심이 아닌, 입력에 따른 출력만이 존재하는 함수형 프로그래밍 방식
        // 자바에서 함수형 프로그래밍을 지원하기 위한 라이브러리 -> StreamAPI
        Arrays.stream(arr).forEach(i -> {
            System.out.println(i);
        });
        Arrays.stream(arr).forEach(System.out::println);

        Arrays.stream(arr).sorted().forEach(System.out::println);

        int[] newarr = Arrays.stream(arr).toArray();

        String[] strArr = {"HTML", "CSS", "JAVA", "PYTHON"};
        // Stream 객체 : 제네릭타입으로 Stream 객체가 생성
        Stream<String> stream = Arrays.stream(strArr);

        int[] intArr = {10, 20, 30, 40, 50};
        IntStream intStream = Arrays.stream(intArr);
        int[] intArr2 = intStream.filter(a -> a > 20).toArray();
        System.out.println(Arrays.toString(intArr2));

        // 참조 변수의 스트림 변환의 경우 제네릭의 타입소거 문제 발생.
        // 제네릭의 타입소거란 java버전의 호환성을 위해 제네릭 타입을 런타임시점에 제거하는 것을 의미.
        String[] strArr2 = Arrays.stream(strArr).filter(a -> a.length() <= 4).toArray(a -> new String[a]);
        System.out.println(Arrays.toString(strArr2));
        strArr2 = Arrays.stream(strArr).filter(a -> a.length() <= 4).toArray(String[]::new);
        System.out.println(Arrays.toString(strArr2));

        // stream 중계연산 : filter, map, sorted, distinct
        // distinct : 중복 제거 후 스트림 반환
        int[] newIntArr = {10, 10, 30, 30, 50};
        int answer = Arrays.stream(newIntArr).distinct().sum();
        System.out.println(answer);

        String[] stArr = {"java", "java", "python", "c++"};
        // 중복 제거 후 새로운 배열 생성
        String[] stArr2 = Arrays.stream(stArr).distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(stArr2));
        answer = Arrays.stream(stArr).distinct().filter(a -> a.length() <= 3).mapToInt(String::length).sum();
        System.out.println(answer);

        // sorted : 정렬된 스트림 반환
        int[] arrn = {5, 1, 2, 3, 5, 7};
        int[] new_arr = Arrays.stream(arrn).sorted().toArray();
        System.out.println(Arrays.toString(new_arr));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(6, 1, 2, 3, 1, 6));
        List<Integer> list2 = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list2);

        List<String> stringList = new ArrayList<>(Arrays.asList("java", "python", "c++", "js"));
        // 문자열의 길이 4 이상을 기준으로 내림차순 정렬후 신규 리스트 생성

        List<String> stringList1 = stringList.stream()
                .filter(a->a.length()>=4)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(stringList1);

        int[] arr_plus10 = Arrays.stream(arrn).map(a->a+10).toArray();
        System.out.println(Arrays.toString(arr_plus10));

        // arr 에서 짝수만 골라서 해당 수의 제곱의 총합을 구하라. sum();
        answer = Arrays.stream(arr).filter(a->a%2==0).map(a->a*a).sum();
        System.out.println(answer);

        // 스트림 소모 : forEach, reduce
        Arrays.stream(arr).forEach(
                System.out::println
        );
        // 초기값을 지정하지 않으면 Optional 객체 return
        answer = Arrays.stream(arr).reduce(1,(a,b)->a*b);
        System.out.println(answer);

        // Optional 객체 : 값이 있을수도 있고 ,없을 수도 있다는 것을 명시한 타입 (java8 이후)
        String a = null;
        // System.out.println(a.length());
        Optional<String> optional = Optional.ofNullable("hello");
        if(optional.isPresent()){
            System.out.println(optional.get().length());
        }
        answer = Arrays.stream(arr).reduce(1, Integer::sum);
        System.out.println(answer);

        String[] starr = {"hello", "java", "world"};
        String s_answer = Arrays.stream(starr).reduce((x, y)->x+", "+y).get();
        System.out.println(s_answer);

        Optional<String> o_answer = Arrays.stream(starr).reduce((x, y)->x+", "+y);
        if(o_answer.isPresent()){
            System.out.println(o_answer.get());
        }

        // 최소,최대,평균,총합,개수
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list.stream().mapToInt(x->x).min().getAsInt());
        System.out.println(list.stream().mapToInt(x->x).max().getAsInt());
        System.out.println(list.stream().mapToDouble(x->x).average().getAsDouble());
        System.out.println(list.stream().mapToInt(x->x).sum());
        System.out.println(list.stream().count());

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍신애", 20));
        studentList.add(new Student("심재혁", 31));
        studentList.add(new Student("조경남", 37));
        studentList.add(new Student("이창선", 58));
        studentList.add(new Student("장준혁", 49));

        System.out.println(studentList.stream().filter(x->x.getAge()>=30).findFirst().get());
        System.out.println(studentList.stream().findAny().get());
        Student s1 = null;
        // 나이가 가장 어린 사람
        s1 = studentList.stream().min((o1, o2) -> o1.getAge() - o2.getAge()).get();
        System.out.println(s1.getName());

        // 30대가 몇명인지
        System.out.println(
                studentList.stream()
                        .filter(x->x.getAge()<=39 && x.getAge()>29)
                        .count()
        );

        // 모든 객체의 평균 나이
        System.out.println(
                studentList.stream()
                        .mapToInt(Student::getAge)
                        .average()
                        .getAsDouble()
        );

        // 30세 이하 선착순 누구인지
        System.out.println(
                studentList.stream()
                        .filter(x->x.getAge()<=30)
                        .findFirst()
                        .get()
                        .getName()
        );

        String st = null;
        if(st != null){
            System.out.println(st.compareTo("abc"));
        }

        // java8 이후에 나온 Optional 객체를 통해
        // 특정 객체에 값이 없을지도 모른다는 것을 명시적으로 표현

        // Optional 객체에 빈 값을 명시적으로 넣는 방법 : Optional.empty();
        Optional<String> opt1 = Optional.empty();

        // 빈값인지 아닌지 확인하는 메서드 : isPresent();
        if(opt1.isPresent()){
            System.out.println(opt1.get().compareTo("abc"));
        }else{
            System.out.println("값이 없습니다.");
        }

        // Optional 객체 생성
        Optional <String> opt2 = Optional.ofNullable("hello"); // null 일수도 있다.

        if(opt2.isPresent()){
            System.out.println(opt2.get());
        }else{
            System.out.println("값이 없습니다.");
        }

        // orElse 관련 메서드 사용하여 null(빈값) 처리
        // orElse(), orElseGet(), orElseThrow()
        // orElse() : 값이 있으면 해당값 return, 없으면 default 지정값 return
        System.out.println(opt2.orElse("").compareTo("abc"));

        // orElseGet() : 값이 있으면 해당값 return, 없으면 매개 변수로 람다함수 또는 메소드 참조
        System.out.println(opt2.orElseGet(String::new).compareTo("abc"));

        // orElseThrow() : 값이 있으면 해당값 return, 없으면 지정된 예외 강제 발생
        int result = opt1.orElseThrow(()-> new NoSuchElementException("예외 : 객체에 값이 없습니다.")).compareTo("abc");
        System.out.println(result);

        // OptionalInt, OptionalDouble
        OptionalInt oi = new ArrayList<>(Arrays.asList(1,2,3,4)).stream().mapToInt(x->x).max();
        System.out.println(oi.orElse(0));

    }
}
