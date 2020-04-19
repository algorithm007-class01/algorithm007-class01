class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {

        int num = 0, row = click[0],col = click[1], n= board.length, m= board[0].length;
        if(board[row][col] == 'M' || board[row][col] == 'X') {
            board[row][col] = 'X';
            return board;
        }

        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow <n && newCol>=0 && newCol<m
                    && board[newRow][newCol] == 'M'){
                num++;
            }
        }

        if(num > 0) {
            board[row][col] = (char) (num + '0');
            return board;
        }
        board[row][col] = 'B';

        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow <n && newCol>=0 && newCol<m
                    && board[newRow][newCol] == 'E'){
                updateBoard(board, new int[]{newRow, newCol});
            }
        }
        return board;
    }
}