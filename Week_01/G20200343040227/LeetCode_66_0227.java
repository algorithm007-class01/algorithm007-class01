
/**
 * https://leetcode-cn.com/problems/plus-one/
 * <p>
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class LeetCode_66_0227 {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        int v = 0;
        while (n >= 0) {
            v = digits[n] + 1;
            if (v < 10) {
                digits[n] = v;
                return digits;
            } else {
                digits[n] = 0;
                n--;
            }
        }
        if (v >= 10) {
            int[] rs = new int[digits.length + 1];
            System.arraycopy(digits, 0, rs, 1, digits.length);
            rs[0] = 1;
            return rs;

            //有网友的解法这段可以优化，更加提高效率，省去拷贝。因为都是0；
            //  int[] rs = new int[digits.length + 1];
            //  rs[0] = 1;
            //  return rs;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] rs = new LeetCode_66_0227().plusOne(new int[]{9, 9, 9});
//        int[] rs = new PlusOne().plusOne(new int[]{9, 9, 8});
        for (int i : rs
        ) {
            System.out.println(i);
        }
    }
}
