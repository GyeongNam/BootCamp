import java.util.Arrays;
import java.util.Comparator;

public class C07_Array {
    public static void main(String[] args) {
        // 표현식 1
        int[] int_arr1 = {1,2,3,4};

        // 표현식 2
        int[] int_arr2 = new int[4];
        for (int i = 0; i < int_arr2.length; i++) {
            int_arr2[i] = i+1;
        }

        // 표현식 3
        int[] int_arr3 = new int[]{1,2,3,4};

        // 표현식 4
        // int[] int_arr4 = new int[]; 반드시 길이가 지정되어야함.

        int[] int_arr4 = new int[]{85,65,90};
        int sum = 0;
        for(int i = 0; i<int_arr4.length; i++){
            sum += int_arr4[i];
        }
        System.out.println(sum/int_arr4.length);

        int[] arr = { 10,20,30,12,8,17};
        int max = arr[0];
        int min = arr[0];
        for(int a : arr){
            if(max<a){
                max = a;
            }
            if(min>a){
                min = a;
            }
        }
        System.out.println(max);
        System.out.println(min);

        int[] arr1 = {10,20};
        int tmp = arr1[0];
        arr1[0] = arr1[1];
        arr1[1] = tmp;
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {10,20,30,40,50,60,70};

        int temp = 0;
        for (int i = 0; i < arr2.length-1; i++) {
            if(arr[i]<arr2[i+1]){
                temp = arr2[i];
                arr2[i] = arr2[i+1];
                arr2[i+1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1,2,3,4,5};
        int[] re1 = new int[arr3.length];
        int[] re2 = new int[arr3.length];
        int j = 0;

        for(int i = arr3.length; i>0; i--){
            re1[j] = arr3[i-1];
            j++;
        }
        System.out.println(Arrays.toString(re1));

        for (int i = 0; i<arr3.length; i++ ){
            re2[arr3.length-1-i] = arr3[i];
        }
        System.out.println(Arrays.toString(re2));
        System.out.println();
        System.out.println(Arrays.toString(arr3));

        for(int i = 0; i<arr3.length/2; i++){
            int tmp2 = arr3[arr3.length-i-1];
            arr3[arr3.length-i-1] = arr3[i];
            arr3[i] = tmp2;
        }
        System.out.println(Arrays.toString(arr3));

        // 에러
//        String[] arr_st =  new String[5];
//        arr_st[0] = "java";
//        arr_st[1] = "c++";
//        arr_st[2] = "python";
//        for (int i = 0; i < arr_st.length; i++) {
//            System.out.println(arr_st[i].length());
//
//        }

        // 정렬 sort 사용
        int[] Arr = {5,1,2,7,3,1,2};
        Arrays.sort(Arr);
        System.out.println(Arrays.toString(Arr));

        // 내림차순 Comparator 객체 사용 , 배열 뒤집기
        // 객체 타입인 경우에만 Comparator 객체 사용 가능
        String[] st_arr1 = {"hello", "hi", "bye", "good_morning"};
        Arrays.sort(st_arr1);
        System.out.println(Arrays.toString(st_arr1));
        Arrays.sort(st_arr1, Comparator.reverseOrder());
        System.out.println(Arrays.toString(st_arr1));

        // Comparator class 는 기본형은 안된다.
        // Arrays.sort(Arr, Comparator.reverseOrder());
        Integer[] Arr_in = {5,1,2,7,3,1,2};
        Arrays.sort(Arr_in, Comparator.reverseOrder());

        for(int i = 0; i<Arr.length/2; i++){
            int tmp2 = Arr[Arr.length-i-1];
            Arr[Arr.length-i-1] = Arr[i];
            Arr[i] = tmp2;
        }
        System.out.println(Arrays.toString(Arr));

        // Stream Api, lambda를 활용한 내림차순 정렬;
        int[] Arr2 = {5,1,2,7,3,1,2};
        int[] new_Arr2 = Arrays.stream(Arr2)    // Arr2를 대상으로 Stream 객체 생성
                .boxed() // Integer 형 변환한 Stream 객체 생성
                .sorted(Comparator.reverseOrder())  // 내림차순 정렬
                .mapToInt(a->a) // Integer -> int 형변환
                .toArray();

        System.out.println(Arrays.toString(new_Arr2));
    }
}
