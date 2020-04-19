/*
 * @lc app=leetcode.cn id=874 lang=csharp
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
using System;
using System.Collections.Generic;

public class Solution {
    /// <summary>
    /// 2^16 = 65536 > 30000 + 30000
    /// 关键点
    /// 1.通过x+y生成障碍点的key
    /// 2.题意是：返回从原点到机器人的最大欧式距离的平方。（不是终点）
    /// </summary>
    /// <param name="commands"></param>
    /// <param name="obstacles"></param>
    /// <returns></returns>
    public int RobotSim (int[] commands, int[][] obstacles) {
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        HashSet<int> obSet = new HashSet<int> ();
        foreach (int[] obstacle in obstacles) {
            int ox = obstacle[0] + 30000;
            int oy = obstacle[1] + 30000;
            obSet.Add ((ox << 16) + oy);
        }

        int x = 0, y = 0, di = 0, ans = 0;
        foreach (int cmd in commands) {
            switch (cmd) {
                case -2:
                    di = (di + 3) % 4;
                    break;
                case -1:
                    di = (di + 1) % 4;
                    break;
                default:
                    for (int i = 0; i < cmd; i++) {
                        int nx = x + dx[di];
                        int ny = y + dy[di];
                        int key = ((nx + 30000) << 16) + (ny + 30000);
                        if (!obSet.Contains (key)) {
                            x = nx;
                            y = ny;
                            ans = Math.Max (ans, x * x + y * y);
                        }
                    }
                    break;
            }
        }
        return ans;
    }
}
// @lc code=end