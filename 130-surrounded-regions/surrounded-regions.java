class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length, cols = board[0].length;

        // Step 1: Mark 'O's connected to border
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        // Step 2: Flip remaining 'O' to 'X', and 'T' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int rows = board.length, cols = board[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'O') return;

        board[i][j] = 'T'; // Temporarily mark as not flippable

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
