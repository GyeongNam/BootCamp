import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class C07_Array {
//    public static void main(String[] args) {
//        // 표현식 1
//        int[] int_arr1 = {1,2,3,4};
//
//        // 표현식 2
//        int[] int_arr2 = new int[4];
//        for (int i = 0; i < int_arr2.length; i++) {
//            int_arr2[i] = i+1;
//        }
//
//        // 표현식 3
//        int[] int_arr3 = new int[]{1,2,3,4};
//
//        // 표현식 4
//        // int[] int_arr4 = new int[]; 반드시 길이가 지정되어야함.
//
//        int[] int_arr4 = new int[]{85,65,90};
//        int sum = 0;
//        for(int i = 0; i<int_arr4.length; i++){
//            sum += int_arr4[i];
//        }
//        System.out.println(sum/int_arr4.length);
//
//        int[] arr = { 10,20,30,12,8,17};
//        int max = arr[0];
//        int min = arr[0];
//        for(int a : arr){
//            if(max<a){
//                max = a;
//            }
//            if(min>a){
//                min = a;
//            }
//        }
//        System.out.println(max);
//        System.out.println(min);
//
//        int[] arr1 = {10,20};
//        int tmp = arr1[0];
//        arr1[0] = arr1[1];
//        arr1[1] = tmp;
//        System.out.println(Arrays.toString(arr1));
//
//        int[] arr2 = {10,20,30,40,50,60,70};
//
//        int temp = 0;
//        for (int i = 0; i < arr2.length-1; i++) {
//            if(arr[i]<arr2[i+1]){
//                temp = arr2[i];
//                arr2[i] = arr2[i+1];
//                arr2[i+1] = temp;
//            }
//        }
//        System.out.println(Arrays.toString(arr2));
//
//        int[] arr3 = {1,2,3,4,5};
//        int[] re1 = new int[arr3.length];
//        int[] re2 = new int[arr3.length];
//        int j = 0;
//
//        for(int i = arr3.length; i>0; i--){
//            re1[j] = arr3[i-1];
//            j++;
//        }
//        System.out.println(Arrays.toString(re1));
//
//        for (int i = 0; i<arr3.length; i++ ){
//            re2[arr3.length-1-i] = arr3[i];
//        }
//        System.out.println(Arrays.toString(re2));
//        System.out.println();
//        System.out.println(Arrays.toString(arr3));
//
//        for(int i = 0; i<arr3.length/2; i++){
//            int tmp2 = arr3[arr3.length-i-1];
//            arr3[arr3.length-i-1] = arr3[i];
//            arr3[i] = tmp2;
//        }
//        System.out.println(Arrays.toString(arr3));
//
//        // 에러
////        String[] arr_st =  new String[5];
////        arr_st[0] = "java";
////        arr_st[1] = "c++";
////        arr_st[2] = "python";
////        for (int i = 0; i < arr_st.length; i++) {
////            System.out.println(arr_st[i].length());
////
////        }
//
//        // 정렬 sort 사용
//        int[] Arr = {5,1,2,7,3,1,2};
//        Arrays.sort(Arr);
//        System.out.println(Arrays.toString(Arr));
//
//        // 내림차순 Comparator 객체 사용 , 배열 뒤집기
//        // 객체 타입인 경우에만 Comparator 객체 사용 가능
//        String[] st_arr1 = {"hello", "hi", "bye", "good_morning"};
//        Arrays.sort(st_arr1);
//        System.out.println(Arrays.toString(st_arr1));
//        Arrays.sort(st_arr1, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(st_arr1));
//
//        // Comparator class 는 기본형은 안된다.
//        // Arrays.sort(Arr, Comparator.reverseOrder());
//        Integer[] Arr_in = {5,1,2,7,3,1,2};
//        Arrays.sort(Arr_in, Comparator.reverseOrder());
//
//        for(int i = 0; i<Arr.length/2; i++){
//            int tmp2 = Arr[Arr.length-i-1];
//            Arr[Arr.length-i-1] = Arr[i];
//            Arr[i] = tmp2;
//        }
//        System.out.println(Arrays.toString(Arr));
//
//        // Stream Api, lambda를 활용한 내림차순 정렬;
//        int[] Arr2 = {5,1,2,7,3,1,2};
//        int[] new_Arr2 = Arrays.stream(Arr2)    // Arr2를 대상으로 Stream 객체 생성
//                .boxed() // Integer 형 변환한 Stream 객체 생성
//                .sorted(Comparator.reverseOrder())  // 내림차순 정렬
//                .mapToInt(a->a) // Integer -> int 형변환
//                .toArray();
//
//        System.out.println(Arrays.toString(new_Arr2));
//
//
//    }
//    public static void main(String[] args) {
//        int[] arr1 = {30,22,20,25,12};
//        int[] arr2 = {30,22,20,25,12};
//        int[] arr3 = {30,22,20,25,12};
//
//        for (int i = 1; i < arr1.length; i++) {
//            for (int j = 1; j < arr1.length; j++) {
//                if(arr1[j]<arr1[j-1]){
//                    int tmp = arr1[j];
//                    arr1[j] = arr1[j-1];
//                    arr1[j-1] = tmp;
//                }
//            }
//            System.out.println(Arrays.toString(arr1));
//        }
//        System.out.println();
//
//        for (int i = 1; i < arr1.length; i++) {
//            for (int j = 1; j < arr1.length; j++) {
//                if(arr1[j]>arr1[j-1]){
//                    int tmp = arr1[j];
//                    arr1[j] = arr1[j-1];
//                    arr1[j-1] = tmp;
//                }
//            }
//            System.out.println(Arrays.toString(arr1));
//        }
//        System.out.println();
//
//        for (int i = 0; i < arr3.length-1; i++) {
//            for (int j = i+1; j < arr3.length; j++) {
//                if(arr3[i]>arr3[j]){
//                    int tmp = arr3[i];
//                    arr3[i] = arr3[j];
//                    arr3[j] = tmp;
//                }
//            }
//            System.out.println(Arrays.toString(arr3));
//        }
//        System.out.println();
//
//        // 숫자 조합의 합 : 각기 다른 다른 숫자의 배열이 있을 때 만들어질 수 있는 2개의 조합의 합을 출력하라.
//        int[] int_arr = {10,20,30,40,50,60};
//        for (int i = 0; i < int_arr.length-1; i++) {
//            for (int j = i+1; j < int_arr.length; j++) {
//                System.out.print(int_arr[i]+int_arr[j] + " ");
//            }
//            System.out.println();
//        }
//    }

//    public static void main(String[] args) {
//        int[] temp ={10,10,40,5,7};
////        int[] new_temp = Arrays.copyOfRange(temp, 0, 3);
////        System.out.println(Arrays.toString(new_temp));
////        HashSet set_arr = new HashSet();
////        for (int i = 0; i < temp.length; i++) {
////            set_arr.add(temp[i]);
////        }
////        System.out.println(set_arr);
//
////        temp = Arrays.stream(temp).distinct().toArray();
////        System.out.println(Arrays.toString(temp));
//
//        Arrays.sort(temp);
//        int[] new_temp = new int[temp.length];
//        int index = 0;
//        for (int i = 0; i < temp.length; i++) {
//            if(i == temp.length-1){
//                new_temp[index] = temp[i];
//                index++;
//                break;
//            }
//            if (temp[i] != temp[i+1]){
//                new_temp[index] = temp[i];
//                index++;
//            }
//        }
//        System.out.println(Arrays.toString(new_temp));
//
//        int[] answer = Arrays.copyOfRange(new_temp,0,index);
//        System.out.println(Arrays.toString(answer));
//    }

//    public static void main(String[] args) {
//        // 버블 정렬
//        int[] arr = {10,30,20,30,40,50,80,70,60};
//        boolean flag = true;
//        for (int i = 1; i < arr.length; i++) {
//            flag = false;
//            for (int j = 0; j < arr.length-1; j++) {
//                if(arr[j] > arr [j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    flag = true;
//                }
//                System.out.println(Arrays.toString(arr));
//            }
//            if(flag != true){
//                break;
//            }
//            System.out.println(i+"차");
//            System.out.println(Arrays.toString(arr));
//        }
//    }

//    public static void main(String[] args) {
//        // 검색
//        int[] arr1 = {5,3,1,8,7};
//        int index = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            if( arr1[i] == 8){
//                index = i;
//            }
//        }
//        System.out.println(index);
//
//        // 이진 검색 Binary Search
//        // 사전에 오름차순 정렬이 되어 있어야 이진검색 가능
//        int[] arr2 = {1,3,6,8,9,11};
//        System.out.println(Arrays.binarySearch(arr2,8));
//
//        // 배열 비교
//        int[] arr3 = {10, 20, 30};
//        int[] arr4 = {10, 20, 30};
//        System.out.println(Arrays.equals(arr3, arr4));
//
//        // 배열 복사
//        // copyOf(배열, end), copyOfRange(배열, start, end)
//        int[] arr5 = {10,20,30,40,50};
//        int[] new_arr1 = Arrays.copyOf(arr5, 10);
//        int[] new_arr2 = Arrays.copyOfRange(arr5, 1, 4);
//        System.out.println(Arrays.toString(new_arr1));
//        System.out.println(Arrays.toString(new_arr2));
//    }

    public static void main(String[] args) {
        // 2차원 배열 할당

        int[][] arr = new int [2][3];
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = temp;
                temp++;
            }
        }
        System.out.println(Arrays.deepToString(arr));

        int[][] arr2 = new int[3][]; // 가변배열
        arr2[0] = new int [1];
        arr2[1] = new int [2];
        arr2[2] = new int [3];
        System.out.println(Arrays.deepToString(arr2));

        int[][] arr3 = {{1,2,3},{1,2,3}};
        System.out.println(Arrays.deepToString(arr3));

        int[][] arr4 = {{1},{1,2},{1,2,3}};
        System.out.println(Arrays.deepToString(arr4));

        System.out.println();
        //  [3][4] 사이즈의 배열을 선언 한 뒤, 1,2,3,~12까지 숫자값을 배열에 할당
        int[][] arr1 = new int [3][4];
        int count = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = count;
                count++;
            }
            System.out.println(Arrays.toString(arr1[i]));
        }
        System.out.println(Arrays.deepToString(arr1));

        System.out.println();
        int[][] arr5 = new int[5][];
        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = new int [i+1];
            for (int j = 0; j < arr5[i].length; j++) {
                arr5[i][j] = (i+1) * 10;
            }
        }
        System.out.println(Arrays.deepToString(arr5));
    }

}

