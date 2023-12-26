package C16_Etc_Class;

import java.util.Arrays;
import java.util.Objects;

public class C1603_Generic_Main {
    public static void main(String[] args) {
        String[] str = {"java", "python", "C++"};
        // 0번째와 1번째 자리 변경
        String_swap(str, 0, 1);
        System.out.println(Arrays.toString(str));

        Integer[] arr = {1,2,3,4,5};
        // 1번째 2번째 자리변경
        int_swap(arr, 1,2);
        System.out.println(Arrays.toString(arr));

        swap(str, 1,2);
        swap(arr, 3,4);
        System.out.println(Arrays.toString(str));
        System.out.println(Arrays.toString(arr));

        GenericStudent<String> stringStudent = new GenericStudent<>("이창선", "29");
        System.out.println(stringStudent.toString());

        GenericStudent<Integer> genericStudent = new GenericStudent<>("이창선", 29);
        System.out.println(genericStudent.toString());

    }
    public static void String_swap(String[] arr, int a, int b){
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void int_swap(Integer[] arr, int a, int b){
        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
    제네릭 메서드 생성 : 반환 타입 원쪽에 <T>
    제네릭은 객체 타입이 들어와야 함에 유의
    */
    public static <T> void swap(T[] arr, int a, int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class GenericClass <T>{
    T value;
    void setValue(T value){
        this.value = value;
    }
    T getValue(){
        return value;
    }
}

class GenericStudent <T> {
    private String name;
    private T age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public T getAge() {
        return age;
    }

    public GenericStudent(String name, T age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return "이름은 "+this.name +" 나이는 "+this.age;
    }
}