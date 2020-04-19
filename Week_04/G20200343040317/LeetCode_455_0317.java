class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        if (g.length * s.length == 0) {
            return ans;
        }
        // 先排序
        // 孩子胃口
        Arrays.sort(g);
        // 饼干Size
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            // 孩子的到满足
            // 代码优化一下，去掉else
            if (g[i] <= s[j++]) {
                i++;
                ans += 1;
            }
        }
        return ans;
    }
}