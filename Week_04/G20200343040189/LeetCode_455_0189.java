//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
//的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
//足越多数量的孩子，并输出这个最大数值。
// 注意：
// 你可以假设胃口值为正。
//一个小朋友最多只能拥有一块饼干。
//
// Related Topics 贪心算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gl = g.length;
        int sl = s.length;
        if (gl == 0 || sl == 0) {
            return 0;
        }
        // 对孩子胃口进行排名
        Arrays.sort(g);
        // 对饼干大小进行排名
        Arrays.sort(s);
        // gi表示满足的小孩数目
        int gi = 0, si = 0;
        while (gi < gl && si < sl) {
            // 孩子胃口与饼干大小做比较
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
