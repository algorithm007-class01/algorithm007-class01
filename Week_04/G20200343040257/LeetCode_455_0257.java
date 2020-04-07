package cxl.study.leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class LeetCode_455_0257 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i = 0;
        for (int child : g) {
            for (; i < s.length; i++) {
                if (child <= s[i]) {
                    result++;
                    i++;
                    break;
                }
            }
        }
        return result;
    }

}
