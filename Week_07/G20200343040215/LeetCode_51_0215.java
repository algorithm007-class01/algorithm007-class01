import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_51_0215 {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        if (n<=0){
            return null;
        }
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board){
            Arrays.fill(chars, '.');
        }
        backtrack(board,0);
        return res;
    }

    private void backtrack(char[][] board, int rows) {
        if (rows== board.length){
            res.add(charToString(board));
            return;
        }
        int n=board[rows].length;
        for (int col=0;col<n;col++){
            if (!isValid(board,rows,col)){
                continue;
            }
            board[rows][col] ='Q';
            backtrack(board,rows+1);
            board[rows][col]='.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        //扫描列
        for (char[]chars :board){
            if (chars[col]=='Q'){
                return false;
            }
        }
        //左上方
        for (int i=row-1,j=col+1;i>=0 && j<rows;i--,j++){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        //右上方
        for (int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        return true;

    }

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }
}
