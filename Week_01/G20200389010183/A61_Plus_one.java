package com.szp.leetcode.q51_100;

/*
* 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。
*
示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
*
示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
链接：https://leetcode-cn.com/problems/plus-one
*
* */
public class A61_Plus_one {
    public int[] plusOne(int[] digits) {
        if(null == digits)
            return digits;
        int length = digits.length;
        for (int i = length-1; i >= 0 ; i--) {
            digits[i] += 1;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0)
                return digits;
        }
        int[] newDigits = new int[length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
