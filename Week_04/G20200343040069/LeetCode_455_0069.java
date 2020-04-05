class Solution {
    // 解题思路：
    // * 由于分配饼干这件事前后的步骤不会产生关联，所以根据贪心算法的原理，分配的最优策略是每次分配只关注未分配饼干的最小胃口的小朋友。
    public int findContentChildren(int[] g, int[] s) {
        if (null == g || null == s) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length){
            if (g[gi] <= s[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }
}