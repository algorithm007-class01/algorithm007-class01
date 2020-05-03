/**
 * 位1的个数
 * <p>
 * n & (n - 1) 获得最低位的1
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
