class Solution {
    int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m = 0;
    int n = 0;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        for(int i=0; i< grid.length;i++){
            n = grid[i].length;
            for(int j=0; j< n; j++){
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i <0 || j<0|| i>=m || j>=n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        for (int[] d:distance) {
            dfs(grid, i + d[0], j+d[1]);
        }
    }

}