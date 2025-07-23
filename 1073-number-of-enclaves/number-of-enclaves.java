class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Remove all lands connected to borders
        for (int i = 0; i < rows; i++) {
            dfs(grid, i, 0);           // Left border
            dfs(grid, i, cols - 1);    // Right border
        }

        for (int j = 0; j < cols; j++) {
            dfs(grid, 0, j);           // Top border
            dfs(grid, rows - 1, j);    // Bottom border
        }

        // Step 2: Count remaining land cells
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

 private void dfs(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 0; // Mark visited (or treated as water now)

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
