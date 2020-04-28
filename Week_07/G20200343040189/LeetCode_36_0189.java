//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
// 说明:
//
//
// 一个有效的数独（部分已被填充）不一定是可解的。
// 只需要根据以上规则，验证已经填入的数字是否有效即可。
// 给定数独序列只包含数字 1-9 和字符 '.' 。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //创建一个静态内部类
    static class Point {
        int row;
        int column;
        char s;

        private Point(int row, int column, char s) {
            this.row = row;
            this.s = s;
            this.column = column;
        }


        @Override
        public boolean equals(Object o) {
            if (getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return row == point.row || column == point.column ||
                    (point.row / 3 == row / 3 && point.column / 3 == column / 3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                Point point = new Point(i, j, board[i][j]);
                if (!set.contains(point)) {
                    set.add(point);
                }
                else return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
