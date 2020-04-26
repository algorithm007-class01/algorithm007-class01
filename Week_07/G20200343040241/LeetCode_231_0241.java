
/**
 *给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class LeetCode_231_0241 {


    public boolean isPowerOfTwo(int n) {
        return  (n > 0 && (n & (n - 1)) == 0);
    }


    public static void main(String[] args) {
        LeetCode_231_0241 leetCode = new LeetCode_231_0241();
        System.out.println(leetCode.isPowerOfTwo(1));
    }
}
