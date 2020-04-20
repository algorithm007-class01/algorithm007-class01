class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        final HashSet<Object> obs = new HashSet<>();
        // 障碍物坐标转化
        for (int[] o : obstacles) {
            obs.add(o[0] + "," + o[1]);
        }
        int max = 0, x = 0, y = 0, dir = 0;
        //转向
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1},{-1, 0}};
        for (int c : commands) {
            //关于dir 的方向说明     0↑
            //                 3← dir →1
            //                     2↓
            // ←
            if (c == -2) {
                dir = dir == 0 ? 3 : dir - 1;

            } else if (c == -1) {
                // →
                dir = dir == 3 ? 0 : dir + 1;
            } else {
                // ↑ 向前走
                int[] xy = dirs[dir]; // 根据方向获取方向上面的计算原子
                // 这里用c-- 可以少定义一个变量
                while (c-- > 0 && !obs.contains((x + dirs[dir][0]) + "," + (y + dirs[dir][1]))) {
                    x = x + xy[0];
                    y = y + xy[1];
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}