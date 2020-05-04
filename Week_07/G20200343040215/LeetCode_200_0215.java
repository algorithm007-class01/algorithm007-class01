public class LeetCode_200_0215 {
    int [] u  =new int []{1,-1,0,0};
    int [] p  =new int []{0,0,1,-1};
    int count=0;
    public int numIslands(char[][] grid) {
        if (grid==null||grid.length==0){
            return 0;
        }
        int rlen = grid.length;
        int clen = grid[0].length;
        for (int i=0;i<rlen;i++){
            for (int j=0;j<clen;j++){
                if (grid[i][j]=='1'){
                    count++;
                    findG(i,j,rlen,clen,grid);

                }
            }
        }
        return count;
    }

    private void findG(int i, int j, int rlen, int clen, char[][] grid) {
        if (i<0||i>=rlen||j<0||j>=clen||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for (int k=0;k<4;k++){
            findG(i+u[k],j+p[k],rlen,clen,grid);
        }
    }

}
