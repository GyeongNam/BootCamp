import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_ListGraph {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    
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
        bfs(0);


    }
    static void addEdge(int a , int b){
        list.get(a).add(b);
        list.get(b).add(a);
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int next = queue.poll();
            System.out.println(next);
            for(int target : list.get(next)){
                if(!visited[target]){
                    visited[target] = true;
                    queue.add(target);
                }
            }
        }

    }
}
