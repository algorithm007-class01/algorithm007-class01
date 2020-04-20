package DailyPractice;

public class LeetCode_200_0215 {


    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0){
            return 0;
        }
        int n=0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int i=0;i<nr;i++){
            for (int j=0;j<nc;j++){
                if (grid[i][j]=='1'){
                    ++n;
                    countIs(grid,i,j);
                }
            }
        }
        return n;
    }

    private void countIs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i<0 || j<0 || i>=nr || j>=nc || grid[i][j]=='0'){
            return ;
        }
        grid[i][j]='0';
        countIs(grid,i-1,j);
        countIs(grid,i+1,j);
        countIs(grid,i,j-1);
        countIs(grid,i,j+1);

    }
}
