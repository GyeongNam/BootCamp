import java.util.*;

public class alogrithm {
    public static void main(String[] args) {
        int [] a= solution(new String[] {
                "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"
        });
        System.out.println(Arrays.toString(a));
       a= solution(new String[] {
                "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
        });
        System.out.println(Arrays.toString(a));
    }
    public static int[] solution(String[] operations) {
//        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> min = new PriorityQueue<>();
//        for (String opStr : operations) {
//            if (opStr.charAt(0) == 'I') {
//                int value = Integer.parseInt(opStr.split(" ")[1]);
//                max.add(value);
//                min.add(value);
//            } else if (opStr.equals("D 1")) {
//                min.remove(max.poll());
//            } else if (opStr.equals("D -1")) {
//                max.remove(min.poll());
//            }
//        }
//        return max.isEmpty() ? new int[] {0, 0} : new int[] {max.peek(), min.peek()};
        TreeSet<Integer> ts = new TreeSet<>();
        for (String opStr : operations) {
            if (opStr.charAt(0) == 'I') {
                int value = Integer.parseInt(opStr.split(" ")[1]);
                ts.add(value);
            } else if (!ts.isEmpty() && opStr.equals("D 1")) {
                ts.pollLast();
            } else if (!ts.isEmpty() && opStr.equals("D -1")) {
                ts.pollFirst();
            }
        }
        return ts.isEmpty() ? new int[] {0, 0} : new int[] {ts.last(), ts.first()};
    }
}
