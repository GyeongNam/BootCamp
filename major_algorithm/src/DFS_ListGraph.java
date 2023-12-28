import java.util.ArrayList;
import java.util.List;

public class DFS_ListGraph {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) {
        int [][] input =  {
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
        System.out.println(list);
        System.out.println();
        dfs(1);
    }
    static void addEdge(int a , int b){
        list.get(a).add(b);
        list.get(b).add(a);
    }

    static void dfs(int start) {
        System.out.println(start);
        visited[start] = true;
        for (int i = 0; i<list.get(start).size(); i++) {
            if(!visited[list.get(start).get(i)]) {
                dfs(list.get(start).get(i));
            }
        }
    }
}
