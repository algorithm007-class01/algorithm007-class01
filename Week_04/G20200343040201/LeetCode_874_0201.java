package myself;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_874_0201 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<String> obstacleSet = new HashSet();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int ans = 0;
        for (int cmd : commands) {
            // 怎样做一个轮回，这招要学一下
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            else {
                // 每次只移动一步
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if (!obstacleSet.contains(nx + "," + ny)) {  // 如果下一步要走的坐标是障碍物，则跳过
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_874_0201().robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
    }


}
