class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] an = new int[n];
        solve(ans,an,n,0);
        return ans;
    }
    private void solve(List<List<String>> ans,int[] an,int n,int level){
        if(level == n){
            save(ans,an);
            return;
        }
        for(int col = 0;col < n; col ++){
            if(isok(an,level,col,n)){
                an[level] = col;
                solve(ans,an,n,level + 1);
            }
        }
    }
    private void save(List<List<String>> ans,int[] an){
        List<String> anList = new ArrayList<>();
        for(int row = 0;row < an.length;row ++){
            StringBuilder sb = new StringBuilder();
            for(int col = 0;col < an.length;col ++){
                if(an[row] == col){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            anList.add(sb.toString());
        }
        ans.add(anList);
    }
    private boolean isok(int[] an,int level,int col,int n){
        int leftup = col-1;
        int rightup = col +1;
        for(int row = level-1;row >=0;row--){
            if(an[row] == col){
                return false;
            }
            if(leftup >= 0){
                if(an[row] == leftup){
                    return false;
                }
            }
            if(rightup < n ){
                if(an[row] == rightup){
                    return false;
                }
            }
            leftup --;
            rightup ++;
        }
        return true;
    }
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

    public class Solution {

        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i;
            }

            int col = 0;
            int master = 0;
            int slave = 0;
            Stack<Integer> stack = new Stack<>();

            backtrack(nums, 0, n, col, master, slave, stack, res);
            return res;
        }

        private void backtrack(int[] nums, int row, int n,
                               int col,
                               int master,
                               int slave,
                               Stack<Integer> stack,
                               List<List<String>> res) {

            if (row == n) {
                List<String> board = convert2board(stack, n);
                res.add(board);
                return;
            }

            // 针对每一列，尝试是否可以放置
            for (int i = 0; i < n; i++) {
                if (((col >> i) & 1) == 0
                        && ((master >> (row + i)) & 1) == 0
                        && ((slave >> (row - i + n - 1)) & 1) == 0) {
                    stack.add(nums[i]);
                    col ^= (1 << i);
                    master ^= (1 << (row + i));
                    slave ^= (1 << (row - i + n - 1));

                    backtrack(nums, row + 1, n, col, master, slave, stack, res);

                    slave ^= (1 << (row - i + n - 1));
                    master ^= (1 << (row + i));
                    col ^= (1 << i);
                    stack.pop();
                }
            }
        }

        private List<String> convert2board(Stack<Integer> stack, int n) {
            List<String> board = new ArrayList<>();
            for (Integer num : stack) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    stringBuilder.append(".");
                }
                stringBuilder.replace(num, num + 1, "Q");
                board.add(stringBuilder.toString());
            }
            return board;
        }


    }


}