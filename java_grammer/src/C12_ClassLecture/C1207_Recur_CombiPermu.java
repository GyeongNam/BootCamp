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
        int n = 2;

        combination(myList,combinations, temp, n, 0);
        System.out.println(combinations);
    }

    static void combination(List<Integer> myList1 , List<List<Integer>> combinations1, List<Integer> temp1,  int n, int start){
        if(temp1.size() == n){
            combinations1.add(new ArrayList<>(temp1));
            return;
        }

        for (int i = start; i < myList1.size(); i++) {
            temp1.add(myList1.get(i));
            combination(myList1, combinations1, temp1, n, i+1);
            temp1.remove(temp1.size()-1);
        }
    }
}

//
//  i = 0
//  1) start = 0 / temp.size = 0 / temp.add get(0) = 1 / com() / temp[1]
//      2) start = 1 / temp.size = 1 / temp.add get(1) = 2 / com() / temp[1,2]
//          3) start = 2 / temp.size = 2 / com.add / return; / remove() / temp[1]
//      4) start = 2 / temp.size = 1 / temp.add get(2) = 3 / com() / temp[1,3]
//          5) start = 3 / temp.size = 2 / com.add / return; / remove() / temp[1]
//      6) start = 3 / temp.size = 1 / temp.add get(3) = 4 / com() / temp[1,4]
//          7) start = 4 / temp.size = 2 / com.add / return; / remove() / temp[1]
//  i = 1
//  8) start = 1 / temp.size = 0 / temp.add get(1) = 2 / com() / temp[2]
//      9) start = 2 / temp.size = 1 / temp.add get(2) = 3 / com() / temp[2,3]
//          10) start = 3 / temp.size = 2 / com.add / return; / remove / temp[2]
//      11) start = 3 / temp.size = 1 / temp.add get(3) = 4 / com() / temp[2,4]
//          12) start = 4 / temp.size = 2 / com.add / return; / remove / temp[2]
//      13) start = temp.size() end;
// i = 2...