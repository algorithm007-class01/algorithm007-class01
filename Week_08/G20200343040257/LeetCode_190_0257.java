package cxl.study.leetcode;

/**
 * 190. 颠倒二进制位
 * https://leetcode-cn.com/problems/reverse-bits/
 */
public class LeetCode_190_ReverseBits {

    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }
}