class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1; // start or end is blocked
        }

        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1; // use grid to store distance

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            int dist = grid[row][col];

            if (row == n - 1 && col == n - 1) {
                return dist; // reached destination
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = dist + 1; // mark visited with distance
                }
            }
        }

        return -1; // no path found
    }
}
