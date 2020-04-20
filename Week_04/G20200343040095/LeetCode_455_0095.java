/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }

        return child;
    }
}
// @lc code=end

