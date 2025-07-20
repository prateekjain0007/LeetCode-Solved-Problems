class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Build the graph (adjacency list)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        return dfs(0, -1, graph, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        int totalTime = 0;

        for (int child : graph.getOrDefault(node, new ArrayList<>())) {
            if (child == parent) continue;

            int childTime = dfs(child, node, graph, hasApple);

            // If child has apple or any of its children did
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }

        return totalTime;
    }
}
