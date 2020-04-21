package myself;

import java.util.Arrays;

public class LeetCode_455_0201 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int sIndex = 0;
        for (int i = 0; i < g.length; ) {
            while (sIndex != s.length) {
                if (g[i] <= s[sIndex++]) {
                    i++;
                    res++;
                    break;
                }
            }
            if (sIndex == s.length)
                break;
        }
        return res;
    }
}
