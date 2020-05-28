//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学

package leetcode.editor.cn;

// 231. 2的幂
public class PowerOfTwo_231 {

    //public static void main(String[] args) {
    //    Solution solution = new PowerOfTwo_231().new Solution();
    //    System.out.println(solution);
    //}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (-n)) == n;
    }

    // 计算n的二进制表示中，符号位之外的1的个数
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        return countOne(n) == 1;
    }
    private int countOne(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            n = n & (n - 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
