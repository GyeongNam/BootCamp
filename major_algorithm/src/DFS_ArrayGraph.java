public class DFS_ArrayGraph {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        graph = new int[][]{
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };

        visited = new boolean[graph.length];

        dfs( 0);
    }

    static void dfs(int start) {
        System.out.println(start);
        visited[start] = true;
        for (int i = 0; i<graph[start].length; i++) {
            if(!visited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
