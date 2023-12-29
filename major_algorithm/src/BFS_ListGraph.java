import java.util.*;

public class BFS_ListGraph {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        int[][] input = {
                {0,1},
                {0,2},
                {1,3},
                {2,3},
                {2,4},
        };
        visited = new boolean[input.length];

        for(int i = 0; i<input.length; i++){
            list.add(new ArrayList<>());
        }

        for (int[] a : input ){
            addEdge(a[0],a[1]);
        }

        distance = new int[input.length];

        int shortest = bfs(0, 3);

        System.out.println(list);
        System.out.println();
        System.out.println(shortest);
    }
    static void addEdge(int a , int b){
        list.get(a).add(b);
        list.get(b).add(a);
    }

    static int bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int next = queue.poll();
//            for(int i = 1 ; i <= 3; i++){ // 3 == 높이길이 - 행의 갯수
//                for (int j = 1; j <= 5; j++) { // 5 ==
//                    /*
//                    1) 시작 노드 표현식 : (i-1) * 5(열 갯수) + j
//                    2) 타켓의 번호와 타켓의 유효성 체크
//                    2-1) 타겟의 번호 : j 에 -1 빼면 왼쪽, j에서 1더하면 오른쪽 등
//                    2-2) 타겟의 유효성 : i와 j가 상하좌우 길이 체크
//                    상하좌우 체크 로직
//                    위쪽에 유효성 체크
//                     */
//                    int[] dx = {-1, 1, 0, 0};
//                    int[] dy = {0, 0, -1, 1};
//                    for (int d = 0; d < 4; d++) {
//                        int targer_i = i + dx[d];
//                        int targer_j = j + dy[d];
//                        if(targer_i>=1 && targer_i<=2 && targer_j>=1 && targer_j<=5){
//                            addEdge((i-1) * 5 + j , (targer_i-1)*5+targer_j);
//                        }
//                    }
//                }
//            }
            for(int target : list.get(next)){
                if(!visited[target]){
                    visited[target] = true;
                    distance[target] = distance[next]+1;
                    queue.add(target);
                    if(target == end){
                        return distance[end];
                    }
                }
            }
        }
        return -1;
    }
//    static void bfs(int start){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//        visited[start] = true;
//        while (!queue.isEmpty()){
//            int next = queue.poll();
//            System.out.println(next);
//            for(int target : list.get(next)){
//                if(!visited[target]){
//                    visited[target] = true;
//                    distance[target] = distance[next]+1;
//                    queue.add(target);
//                }
//            }
//        }
//    }
}
