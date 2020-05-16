class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2*n], new boolean[2*n], new String[n], res);
        return res;
    }

    private void helper(int index, boolean[] cols, boolean[] pie, boolean[] na, String[] board,  List<List<String>> res){
        if(index == board.length){
            res.add(Arrays.asList(board.clone()));
            return;
        }

        for(int i = 0; i< board.length;i++){
            int d1 = index - i + board.length;
            int d2 = 2 * board.length - index - i -1;

            if(cols[i] || pie[d1] || na[d2]) continue;

            char[] row = new char[board.length];
            Arrays.fill(row, '.');
            row[i] = 'Q';

            board[index] = new String(row);
            cols[i] =true;
            pie[d1] = true;
            na[d2] = true;
            helper(index +1, cols, pie, na, board, res);
            cols[i] = false;
            pie[d1] = false;
            na[d2] = false;

        }
    }
}