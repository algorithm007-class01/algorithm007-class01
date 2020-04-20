import java.util.Arrays;

public class LeetCode_455_0145 {
    /**
     *  分配饼干，满足了就分配，不满足了换下块饼干
     *  之所以这么做，是因为已经对学生的饱食度、饼干饱食度进行了排序
     * */
    public static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;

        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }
}
