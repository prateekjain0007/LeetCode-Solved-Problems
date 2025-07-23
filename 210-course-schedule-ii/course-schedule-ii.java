class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph and in-degree array
        for (int[] pre : prerequisites) {
            int to = pre[0];
            int from = pre[1];
            adj.get(from).add(to);
            inDegree[to]++;
        }

        // Queue for BFS (starting with nodes having in-degree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Topological sort
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;

            for (int neighbor : adj.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all courses were added → cycle exists
        if (index != numCourses) return new int[0];
        return result;
    }
}
