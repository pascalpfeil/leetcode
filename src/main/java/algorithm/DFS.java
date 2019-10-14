package algorithm;

import java.util.Stack;

public class DFS {
    private static int GRAPH_SIZE;
    private static int[][] adj_matrix = new int[GRAPH_SIZE][GRAPH_SIZE];

    public static void dfs(int start) {
        boolean[] visited = new boolean[GRAPH_SIZE];
        visit(start, visited);
    }

    private static void visit(int current, boolean[] visited) {
        visited[current] = true;

        System.out.println(current); // or whatever logic

        for (int dst : adj_matrix[current])
            if (!visited[dst])
                visit(dst, visited);
    }

    private static void dfs_iterative(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[GRAPH_SIZE];
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;

            System.out.println(current); // or whatever logic

            for (int dst : adj_matrix[current])
                if (!visited[dst])
                    stack.push(dst);
        }
    }
}
