/*
 * @lc app=leetcode.cn id=66 lang=swift
 *
 * [66] 加一
 */

// @lc code=start
//  解法一： 从后往前判断，先单独判断最后一位，然后根据是否进位来进行计算
class Solution {
    func plusOne(_ digits: [Int]) -> [Int] {
        var nums = digits
        // 是否需要进位
        var max = 0
        if nums[nums.count - 1] == 9{
            max = 1
        }

        for i in 0..<nums.count {
            let index = nums.count - i - 1
            // 需要进位
            if max == 1 {
                nums[index] = 0
                if index > 0 {
                    // 前一位存在
                    if nums[index - 1] == 9 {
                        max = 1
                    }else{
                        max = 0
                    }
                }else {
                    //  前一位不存在，但是需要进位
                    nums.insert(1, at: 0)
                }
            }else {
                 nums[index] += 1 
                 break
            }
        }
        return nums
    }
}

//  去掉 max 代表进位的变量，直接从后往前遍历并计算

class Solution {
    func plusOne(_ digits: [Int]) -> [Int] {
        var nums1 = digits
        var curIndex = nums1.count - 1
        let curEle = nums1[curIndex]
        //  根据最后一位是否为 9 向前计算
        if curEle != 9{
            nums1[curIndex] += 1
        }else{
            nums1[curIndex] = 0
            while curIndex > 0 {
                curIndex -= 1
                if nums1[curIndex] != 9{
                    nums1[curIndex] += 1
                    break
                }else{
                    nums1[curIndex] = 0
                }
            }
            
            if nums1[0] == 0 {
                nums1.insert(1, at: 0)
            }
        }
         return nums1
    }
}

//  更简。遍历过程中遇到不等于 9 的位置就可以停下
public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        digits[i] = 0;
    }
    // 此处是 java 写法，swif 直接调用插入方法
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    return newNumber;
}


//  上述两种方法，思路基本一致，从末尾开始往前依次判断是否需要进位，然后才进行计算
//  下一个方法，先进行计算，然后判断结果是否进位

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

// @lc code=end

