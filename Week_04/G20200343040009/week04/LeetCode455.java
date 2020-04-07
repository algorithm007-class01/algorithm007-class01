import java.util.Arrays;

public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        // 升序排序
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            // 当小孩的最小胃口被满足即可换下一个小孩进行投食
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
