import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Topological sorting is an ordering of the vertices in a directed acyclic graph (DAG) such that for every directed edge
𝑢 → 𝑣, vertex 𝑢 comes before vertex 𝑣 in the ordering

Approaches:
1. Kahn's Algorithm: Uses in-degree of nodes and a queue.
2. DFS-based Algorithm: Uses a stack to store the vertices in reverse post-order of their DFS traversal.

Use-case:
- Problems with dependency graphs
- Schedule task: Task A should be performed before task B
- DAG graph
 */

public class TopologicalSort {
    private void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> graph) {
        visited[node] = true;
        // Explore all neighbors
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor, visited, stack, graph);
            }
        }
        // Push node to stack after visiting all neighbors
        stack.push(node);
    }

    public List<Integer> topologicalSort(int vertices, List<List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        // DFS all vertices
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) {
                dfs(i, visited, stack, graph);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
