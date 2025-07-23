class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    count++;
                    //all directions call
                       dfs(grid,i,j);

                }
            }
        }
        return count;
    }
    void dfs(char [][]grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;//backtracking starts
        }
//mark current cell as visited
grid[i][j]='0';//land is sink mark as visited
dfs(grid,i+1,j);//move down
dfs(grid,i-1,j);
dfs(grid,i,j+1);//right
dfs(grid,i,j-1);


    }
}