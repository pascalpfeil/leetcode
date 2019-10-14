package algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    private static int GRAPH_SIZE;
    private static int[][] adj_matrix = new int[GRAPH_SIZE][GRAPH_SIZE];

    public static void dfs(int start) {
        boolean[] visited = new boolean[GRAPH_SIZE];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            System.out.println(current); // or whatever logic

            for (int dst : adj_matrix[current]) {
                if (!visited[dst]) {
                    visited[dst] = true;
                    queue.add(current);
                }
            }
        }
    }

}
