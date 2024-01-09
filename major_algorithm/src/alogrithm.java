import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class alogrithm {
    public static void main(String[] args) {
        solution(new int[] {1, 2, 3, 4, 5}, 7);
        solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5);
        solution(new int[] {2, 2, 2, 2, 2}, 6);

    }
    public static int[] solution(int[] sequence, int k) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<List<Integer>> indexList = new ArrayList<>();
//        int[] answer = new int[2];

        for(int i = 0; i<sequence.length; i++){
            List <Integer> sumlist = new ArrayList<>();
            List <Integer> intIndex = new ArrayList<>();
            for(int j = i; j<sequence.length; j++){
                int sum = sumlist.stream().mapToInt(a->a).sum();
                if(k == sum ){
                    list.add(sumlist);
                    indexList.add(intIndex);
                }else{
                    sumlist.add(sequence[j]);
                    intIndex.add(j);
                }
            }
            if(k == sumlist.stream().mapToInt(a->a).sum() ){
                list.add(sumlist);
                indexList.add(intIndex);
            }
        }
        int size = list.get(0).size();
//        answer[0] = indexList.get(0).get(0);
//        answer[1] = indexList.get(0).get(indexList.get(0).size()-1);
//        for(int i = 0; i< list.size(); i++){
//            if(list.get(i).size() < size){
//                answer[0] = indexList.get(i).get(0);
//                answer[1] = indexList.get(i).get(indexList.get(i).size()-1);
//            }
//        }
//        System.out.println(list);
//        System.out.println(indexList);
//        System.out.println(Arrays.toString(answer));
        int[] answer = new int[2];
        int sum = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];
             if (sum == k) {
                if (length > end - start) {
                    length = end - start;
                    answer[0] = start;
                    answer[1] = end;
                }
            }
            else if (sum > k) {
                // start 를 당기겠다.
                for (int j = start; j <= end; j++) {
                    sum -= sequence[j];
                    if (sum <= k) {
                        start = j + 1;
                        break;
                    }
                }
                if (sum == k) {
                    if (length > end - start) {
                        length = end - start;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;

    }
}
