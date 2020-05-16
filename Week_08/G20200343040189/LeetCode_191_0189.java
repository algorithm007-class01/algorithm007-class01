//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
//
// Related Topics 位运算


//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 记录1的个数
        int count = 0;
        // 32位无符号整数，最多循环32次
        // n跟1进行按位与操作
        for (int i = 0; i < 32; i++) {
            count += ((n >> i) & 1) == 1 ? 1 : 0;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)