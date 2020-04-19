import java.util.Arrays;

public class LeetCode_455_0059 {


    /**
     * 输入: [1,2,3], [1,1]
     * <p>
     * 输出: 1
     * <p>
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        System.out.println(findContentChildren(null, null));
    }

    public static int findContentChildren(int[] g, int[] s) {

        g = new int[]{1, 2, 3};
        s = new int[]{1, 1};


        Arrays.sort(g);
        Arrays.sort(s);
        // 还是贪心算法,如果满足,直接就++
        int res = 0;

        for (int i = 0; i < g.length; i++) {
            int need = g[i];
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= need) {
                    res++;
                    s[j] = 0;
                    break;
                }
            }
        }
        return res;
    }
}
