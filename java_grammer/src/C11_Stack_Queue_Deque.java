import java.util.*;

public class C11_Stack_Queue_Deque {
//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//
//        System.out.println(stack.pop());
//
//        System.out.println(stack.peek());
//
//        System.out.println(stack);
//
//        System.out.println(stack.size());
//
//        System.out.println(stack.isEmpty());
//
//        // String 객체 5개 정도 stack 에 추가후 while문을 통해 모두 출력.
//        Stack<String> stack1 = new Stack<>();
//        stack1.push("1");
//        stack1.push("2");
//        stack1.push("3");
//        stack1.push("4");
//        stack1.push("5");
//
//        while (!stack1.isEmpty()){
//            System.out.println(stack1.pop());
//        }
//
//        // 웹 페이지 방문 뒤로 가기 기능 구현
//        // 방문한 사이트 출력 + 뒤로가기 기능 구현
//        // 스캐너로 신규사이트 방문 or 뒤로가기
//        // 뒤로가기 일 경우 해당 주소 pop
//        Stack<String> stack2 = new Stack<>();
//        Stack<String> stack3 = new Stack<>();
//        System.out.println("사이트 입력하세요. 0,00 제외");
//        Scanner sc = new Scanner(System.in);
//        String page_num = sc.nextLine();
//        stack2.push(page_num);
//        while (!stack2.isEmpty()){
//            System.out.println(stack2);
//            System.out.println(stack3);
//            System.out.println("현재 사이트는 "+ stack2.peek() + " 입니다.");
//            System.out.println("사이트 입력하세요.");
//            System.out.println("뒤로 가기를 원하시면 '0'을 입력해주세요");
//            if(stack3.size()>0){
//                System.out.println("앞으로 가기를 원하시면 '00'을 입력해주세요");
//            }
//            page_num = sc.nextLine();
//            if(page_num.equals("0")){
//                stack3.push(stack2.pop());
//            }else if(page_num.equals("00")){
//                stack2.push(stack3.pop());
//            }else{
//                stack2.push(page_num);
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(10);
//        q.add(20);
//        q.add(30);
//        System.out.println(q.poll());
//        System.out.println(q);
//
//        // 프린터 대기열 예제
//        // 문서 1추가, 문서 2추가, 문서 3추가,
//        // while 문을 통해 "현재 인쇄 중인 문서 : 문서1" 포맷으로 출력
//        Queue<String> q1 = new LinkedList<>();
//        q1.add("문서1");
//        q1.add("문서2");
//        q1.add("문서3");
//        while (!q1.isEmpty()){
//            System.out.println("현재 인쇄 중인 문서 : "+q1.poll());
//        }
//
//    }

//    public static void main(String[] args) {
//        // 길이의 제한이 있는 큐 : ArrayBlockingQueue
//        Queue<String> q = new ArrayBlockingQueue<>(3);
//        // add: 길이가 다 차면 error
//        // offer : 공간이 충분할 때만 add
//        q.add("1");
//        q.add("2");
//        q.add("3");
//        // q.add("4"); 에러
//        q.offer("4");
//
//        System.out.println(q);
//    }

//    public static void main(String[] args) {
//        // 우선순위 큐
//        Queue<Integer> pq = new PriorityQueue<>();
//        pq.add(3);
//        pq.add(2);
//        pq.add(1);
//        pq.add(4);
//        pq.add(5);
//
//        System.out.println(pq);
//    }

    public static void main(String[] args) {

        // 양뱡향에서 데이터 삽입/제거 할 수 있다.
        // 성능 빠름
        Deque<Integer> d = new ArrayDeque<>();
        d.addFirst(10);
        d.addLast(20);
        System.out.println(d);
        d.addLast(30);
        System.out.println(d);

        System.out.println(d.pollFirst());
        System.out.println(d.pollLast());
        System.out.println(d);

    }


}
