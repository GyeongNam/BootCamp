package C15_Anonymous_Lambda;

import java.util.*;

public class C1505_SteamAPI {
    public static void main(String[] args) {
        int[] arr ={20,10,4,12};
        // 데이터와 객체 중심이 아닌, 입력에 따른 출력만이 존재하는 함수형 프로그래밍 방식
        // 자바에서 함수형 프로그래밍을 지원하기 위한 라이브러리 -> StreamAPI
        Arrays.stream(arr).forEach( i ->{
            System.out.println(i);
        });
        Arrays.stream(arr).forEach(System.out::println);

        Arrays.stream(arr).sorted().forEach(System.out::println);

        int[] newarr = Arrays.stream(arr).toArray();

    }
}
