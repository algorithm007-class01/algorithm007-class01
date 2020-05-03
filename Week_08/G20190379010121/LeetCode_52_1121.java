class Solution {
    private int sum = 0;
    public int totalNQueens(int n) {
        this.sum = 0;
        int[] res = new int[n];
        solve(n,0,res);
        return this.sum ;
    }
    private void solve(int n,int level,int[] res){
        if(level == n){
            this.sum ++;
            return ;
        }
        for(int col = 0;col < n ; col ++){
            if(isok(n,level,col,res)){
                res[level] = col;
                solve(n,level + 1,res);
            }
        }
    }
    private boolean isok(int n,int level,int col,int[] res){
        int leftup = col-1;
        int rightup = col +1;
        for(int row = level -1; row >= 0; row--){
            if(res[row] == col){
                return false;
            }
            if(leftup >= 0){
                if(res[row] == leftup){
                    return false;
                }
            }
            if(rightup < n){
                if(res[row] == rightup){
                    return false;
                }
            }
            leftup --;
            rightup ++;
        }
        return true;
    }
}