package DailyPractice;

public class LeetCode_529_0215 {

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 相邻位置
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


    public char[][] updateBoard(char[][] board, int[] click) {
            dfs(board,click[0],click[1]);
            return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int xmax = board.length;
        int ymax = board[0].length;
        if (x<0 || x>=xmax || y<0 || y>=ymax){
            return ;
        }

        if (board[x][y]== 'E' ) {
            board[x][y]='B';
            int  count = boomNum(board,x,y);
            if (count == 0) {
                for (int i=0;i < 8;i++){
                    dfs(board, x+dx[i],y+dy[i]);
                }
            }else {
                board[x][y] = (char) (count + '0');
            }
        }else if (board[x][y]=='M'){
            board[x][y] = 'X';
        }
    }

    private int boomNum(char[][] board, int x, int y) {
        int r = board.length;
        int c = board[0].length;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= r || newY < 0 || newY >= c) {
                continue;
            }
            if (board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;

    }
}
