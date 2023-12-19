package C12_ClassLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1207_Recur_CombiPermu {
    public static void main(String[] args) {
        //        for (int i = 0; i < myList.size(); i++) {
//            temp.add(myList.get(i));
//            for (int j = i + 1; j < myList.size(); j++){
//                temp.add(myList.get(i));
//                combinations.add(new ArrayList<>(temp));
//                temp.remove(temp.size()-1);
//            }
//            temp.remove(temp.size()-1);
//        }
//        for(int i =0; i < myList.size(); i++){
//            for(int j = i+1; j <myList.size(); j++){
////                combinations.add(new ArrayList<>(Arrays.asList(myList.get(i), myList.get(j))));
//                List<Integer> temp = new ArrayList<>();
//                temp.add(myList.get(i));
//                temp.add(myList.get(j));
//                combinations.add(temp);
//            }
//        }


        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[myList.size()];
        int n;

//        n = 2;
//        combination1(myList,combinations, temp, n, 0);
//        System.out.println(combinations);
//        n = 3;
//        combinations = new ArrayList<>();
//        boolean[] visited = new boolean[myList.size()];
//        permutation1(myList,combinations, temp, n,  visited);
//        System.out.println(combinations);

        // 합계가 6인 순열만 2개 순열 출
        n = 2;
        combination2(myList,combinations, temp, n, visited);
        System.out.println(combinations);

        // 합계가 6인 모든 순열 add
        combinations = new ArrayList<>();
        visited = new boolean[myList.size()];
        permutation2(myList,combinations, temp,  visited);
        System.out.println(combinations);

        // 모든 순열에서 합계가 가장 큰
        combinations = new ArrayList<>();
        visited = new boolean[myList.size()];
        permutation3(myList,combinations, temp,  visited);
        System.out.println(max);

        // 3개 순열 합계가 가장 큰 값
        combinations = new ArrayList<>();
        visited = new boolean[myList.size()];
        n = 3;
        max = 0;
        permutation4(myList,combinations, n, visited, 0, 0);
        System.out.println(max);
    }

//    static void combination1(List<Integer> myList1 , List<List<Integer>> combinations1, List<Integer> temp1,  int n, int start){
//        if(temp1.size() == n){
//            combinations1.add(new ArrayList<>(temp1));
//            return;
//        }
//
//        for (int i = start; i < myList1.size(); i++) {
//            temp1.add(myList1.get(i));
//            combination(myList1, combinations1, temp1, n, i+1);
//            temp1.remove(temp1.size()-1);
//        }
//    }

//    static void permutation1(List<Integer> myList1 , List<List<Integer>> combinations1, List<Integer> temp1,  int n, boolean[] visited){
//        if(temp1.size() == n){
//            combinations1.add(new ArrayList<>(temp1));
//            return;
//        }
//
//        for (int i = 0; i < myList1.size(); i++) {
//            if(!visited[i]){
//                visited[i] = true;
//                temp1.add(myList1.get(i));
//                permutation(myList1, combinations1, temp1, n, visited);
//                temp1.remove(temp1.size()-1);
//                visited[i] = false;
//            }
//        }
//    }

    // 합계가 6인 순열만 2개 순열 출
    static void combination2(List<Integer> myList1 , List<List<Integer>> combinations1, List<Integer> temp1,  int n, boolean[] visited){
        if(temp1.size() == n && temp1.stream().mapToInt(Integer::intValue).sum() >= 6){
            combinations1.add(new ArrayList<>(temp1));
            return;
        }
//        int  total = 0;
//        if(temp1.size() == n){
//            for(int a : temp1){
//                total += a;
//            }
//            if(total>=6){
//                combinations1.add(new ArrayList<>(temp1));
//            }
//        }

        for (int i = 0; i < myList1.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                temp1.add(myList1.get(i));
                combination2(myList1, combinations1, temp1, n, visited);
                temp1.remove(temp1.size()-1);
                visited[i] = false;
            }
        }
    }
    // 합계가 6인 모든 순열 add
    static void permutation2(List<Integer> myList1 , List<List<Integer>> combinations1, List<Integer> temp1, boolean[] visited){
        if(temp1.stream().mapToInt(Integer::intValue).sum() >= 6 ){
            combinations1.add(new ArrayList<>(temp1));
        }

        for (int i = 0; i < myList1.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                temp1.add(myList1.get(i));
                permutation2(myList1, combinations1, temp1, visited);
                temp1.remove(temp1.size()-1);
                visited[i] = false;
            }
        }
    }

    // 모든 순열에서 합계가 가장 큰
    static int max;
    static void permutation3(List<Integer> myList1 , List<List<Integer>> combinations1, List<Integer> temp1, boolean[] visited){
        if(temp1.stream().mapToInt(Integer::intValue).sum() >= max){
            max = temp1.stream().mapToInt(Integer::intValue).sum();
            combinations1.add(new ArrayList<>(temp1));
        }
        for (int i = 0; i < myList1.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                temp1.add(myList1.get(i));
                permutation3(myList1, combinations1, temp1, visited);
                temp1.remove(temp1.size()-1);
                visited[i] = false;
            }
        }
    }

    // 3개 순열 합계가 가장 큰 값, temp list 사용 없이
    static void permutation4(List<Integer> myList1 , List<List<Integer>> combinations1, int n, boolean[] visited, int temp, int count){
        if(count == n && temp >= max){
            max = temp;
            return;
        }

        for (int i = 0; i < myList1.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                permutation4(myList1, combinations1, n, visited, temp + myList1.get(i),count+1);
                visited[i] = false;
            }
        }
    }
}