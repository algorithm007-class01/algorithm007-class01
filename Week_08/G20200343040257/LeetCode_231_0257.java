package cxl.study.leetcode;

/**
 * 231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class LeetCode_231_PowerOfTwo {

    /**
     * 排除0
     * 如果n为2的幂次方 则 n & (n-1) = 0成立
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }


}
