class Solution {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 相邻位置
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = board.length;
        int c = board[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(click[0], click[1]));
        while(!queue.isEmpty()) {
            Node top = queue.poll();
            int x = top.x;
            int y = top.y;
            if (board[x][y] == 'E') { // 如果当前为E，才进行判断是否要递归相邻结点
                board[x][y] = 'B';
                int count = judge(board, x, y);
                if (count == 0) { // 如果为0，则进行递归
                    for (int i = 0; i < 8; i++) {
                        int newX = x + dx[i];
                        int newY = y + dy[i];
                        if (newX < 0 || newX >= r || newY < 0 || newY >= c) {
                            continue;
                        }
                        queue.offer(new Node(newX, newY));
                    }
                } else { // 如果不为0，则不加入队列，同时更新当前结点的值为地雷数量
                    board[x][y] = (char) (count + '0');
                }
            } else if (board[x][y] == 'M') { // 如果当前为M，则只更新当前结点
                board[x][y] = 'X';
            }  
        }
        return board;
    }

    // 获取当前节点相邻的地雷数量
    public int judge(char[][] board, int x, int y) {
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

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}