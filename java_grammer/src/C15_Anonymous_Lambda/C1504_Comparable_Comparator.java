package C15_Anonymous_Lambda;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class C1504_Comparable_Comparator   {
    // 자바에서는 비교를 위한 인터페이스가 대표적으로 2개 제공
    // Comparable , Comparator
    // Comparable 인테페이스에는 compareTo 메서드가 선언,
    // 그리고 자바의 많은 클래스에서 구현하고 있음. (일반적으로 클래스 내에서 직접 구현해서 사용하는 항식)
    // Comparator 인터페이스에는 compare 메서드가 선언,
    // 일반적으로 익명 객체를 만들어서 활용

    // 두 문자열의 각 문자를 앞에서부터 순차적으로 비교
    // 문자열의 자릿수의 차이가 발생할 때, 그 문자의 유니코드 값의 차이를 반환
    public static void main(String[] args) {
        String a = "hello";
        String b = "world";
        System.out.println(a.compareTo(b));

        Integer inta = 1;
        Integer intb = 1;
        System.out.println(inta.compareTo(intb));

        List<String> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        Collections.sort(list); // 오름차순 Comparable의 compareTo 메서드를 통해 정렬
        Collections.sort(list, Comparator.naturalOrder());
        Collections.sort(list, Comparator.reverseOrder());

        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("조경남", 27));
        list1.add(new Student("이창선", 29));
        list1.add(new Student("홍신애", 23));
        list1.add(new Student("심재혁", 25));
        list1.add(new Student("한종승", 26));



        // 정렬 방법 1 : Comparable 인터페이스 implements 후 compareTo 메서드 구현, 매개변수 1개
        // 나이 기준 정렬
        list1.sort((o1, o2) -> {
            // 기본은 오름차순 (음수 오름차순)
            return o1.getAge() - o2.getAge();
        });
        // 이름으로 정렬
        list1.sort((o1, o2)->{
         return o1.getName().compareTo(o2.getName());
        });

        for (Student s : list1){
            System.out.println(s.toString());
        }

        String[] strarr = {"hello", "java", "C++", "world"};

        Arrays.sort(strarr, (o1, o2) -> o1.length() - o2.length());

        System.out.println(Arrays.toString(strarr));
        Queue<String> q = new PriorityQueue<>((o1, o2) -> o2.length() - o1.length());
          //(Comparator.reverseOrder());

        // 3, 30, 34, 5, 9
        // 문자로 이루어진 가장 큰 숫자를 구하라
//        String[] str = {"3","30","34","5","9"};
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2+o1).compareTo(o1+o2);
//            }
//        });
//        System.out.println(Arrays.stream(str).collect(Collectors.joining("")));

//        int[] numbers = {3,30,34,5,9};
        System.out.println("12312123");
        int[] numbers = {0,0,0};
        String answer = "";
        String[] str =  Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        System.out.println(Arrays.toString(str));
        answer = str[0];
        for(int i =1; i<str.length; i++){
            if(str[i-1].equals("0") && str[i].equals("0")){

            }else{
                answer += str[i];
            }
        }
//        answer = Arrays.stream(str).collect(Collectors.joining(""));
//        answer = String.valueOf(Long.parseLong(answer));

        System.out.println(answer);
        // 정렬 방법 2 : Comparator 를 익명 객체 방식으로 활용하여 정렬, 매개변수 2개
        Collections.sort(list1);
        System.out.println(list1);
        "hello".compareTo("world");

        // 쓰레드 구현방식 : 쓰레드 상속, Runnable 방식


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("새로만든 쓰레드 입니다.");
            }
        });
        Thread t2 = new Thread(() -> System.out.println("새로만든 쓰레드 입니다."));
        t1.start();
        t2.start();
        System.out.println("main의 쓰레드 입니다.");

    }
}

class Student implements Comparable<Student>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // 조상 클래스인 Object 클래스의 toString 을  오버라이딩 하여 객체 호출 시 자동으로 toString 메서드에서 호출
    @Override
    public String toString(){
        return "이름은 "+this.name +" 나이는 "+this.age;
    }

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return this.name.compareTo(o.name);
    }
}
