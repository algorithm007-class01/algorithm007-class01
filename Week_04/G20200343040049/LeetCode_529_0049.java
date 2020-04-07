// dfs

class Solution {
    int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    int m;
    int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board.length == 0 || board[0].length == 0 || click.length != 2)
            return board;

        m = board.length;
        n = board[0].length;
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n)
            return;

        if (board[x][y] == 'E') {
            // 相当于visited数组，修改成B就不再考虑。
            board[x][y] = 'B';
            int count = judge(board, x, y);
            if (count == 0) {
                for (int i = 0; i < 8; ++i)
                    dfs(board, x + dx[i], y + dy[i]);

            } else {
                board[x][y] = (char) ('0' + count);
            }
        } else if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
    }

    private int judge(char[][] borad, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; ++i) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (newx < 0 || newx >= m || newy < 0 || newy >= n)
                continue;
            if (borad[newx][newy] == 'M')
                count++;
        }
        return count;
    }
}

// bfs

// class Solution {
//     class Node {
//         private int x;
//         private int y;

//         public Node(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }
//     }

//     int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
//     int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
//     int m;
//     int n;

//     public char[][] updateBoard(char[][] board, int[] click) {
//         if (board.length == 0 || board[0].length == 0 || click.length != 2)
//             return board;

//         m = board.length;
//         n = board[0].length;
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(new Node(click[0], click[1]));

//         while (!queue.isEmpty()) {
//             Node node = queue.poll();
//             int x = node.x;
//             int y = node.y;
//             if (board[x][y] == 'E') {
//                 board[x][y] = 'B';
//                 int count = judge(board, x, y);
//                 if (count == 0) {
//                     for (int i = 0; i < 8; ++i) {
//                         int newx = x + dx[i];
//                         int newy = y + dy[i];
//                         if (newx < 0 || newx >= m || newy < 0 || newy >= n)
//                             continue;
//                         queue.offer(new Node(newx, newy));
//                     }
//                 } else {
//                     board[x][y] = (char) ('0' + count);
//                 }
//             } else if (board[x][y] == 'M')
//                 board[x][y] = 'X';
//         }
//         return board;
//     }

//     private int judge(char[][] borad, int x, int y) {
//         int count = 0;
//         for (int i = 0; i < 8; ++i) {
//             int newx = x + dx[i];
//             int newy = y + dy[i];
//             if (newx < 0 || newx >= m || newy < 0 || newy >= n)
//                 continue;
//             if (borad[newx][newy] == 'M')
//                 count++;
//         }
//         return count;
//     }
// }
