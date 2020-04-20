import java.util.Arrays;

public class LeetCode_455_0147 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int summary = 0;
        for (int i = 0, j = 0; i < s.length & j < g.length; ) {
            if (s[i] >= g[j]) {
                summary++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return summary;
    }
}
