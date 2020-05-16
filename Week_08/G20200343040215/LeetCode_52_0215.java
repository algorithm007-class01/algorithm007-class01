public class LeetCode_52_0215 {
    private int size,count;
    public int totalNQueens(int n) {
        size = (1<<n)-1;
        count =0;
        solve(0,0,0);
        return count;
    }
    private void solve(int row, int ld, int rd) {
        if (row==size){
            count++;
            return ;
        }
        int pos = size & (~(row |ld | rd));//表示在该行还有哪个坑还可以用

        while (pos!=0){
            int p=pos & (-pos);//找到最右边的1
            pos-= p ;//pos &=pos-1;去掉坑位 该位置为0
            solve(row|p, (ld|p)<<1, (rd|p)>>1 );//对于下一行的影响：撇捺的影响在下一行就是左右两个坑位不能填了
        }

    }
}
