/*
 * @lc app=leetcode.cn id=88 lang=swift
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
// 暴力解法： 合并之后直接对数组排序
// 解法一： 从后往前合并
class Solution {
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var p = m + n - 1
        var i = m - 1
        var j = n - 1
        while i >= 0 && j >= 0 {
            if nums1[i] > nums2[j] {
                nums1[p] = nums1[i]
                p -= 1
                i -= 1
            }else{
                nums1[p] = nums2[j]
                p -= 1
                j -= 1
            }
        }
        
        while j >= 0 {
            
            nums1[p] =  nums2[j]
            j -= 1
            p -= 1
        }

    }
}

// 解法二： 从前往后合并
class Solution {
    func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var p1 = 0
        var p2 = 0
	     //   最后一位有效下标，每次插入之后，都会+1
        var last = m - 1
			//   i 代表插入次数，也就是 n
        var i = 0
        while i < n && p1 <= last {
            
            if nums2[p2] < nums1[p1] {
                //   last - p1 代表的是需要向后移动的个数
                for k in 0...(last-p1) {
                    nums1[last + 1 - k ] = nums1[last - k]
                }
                
                nums1[p1] = nums2[p2]
                p1 += 1
                p2 += 1
                
                last += 1
                i += 1
            }else{
                p1 += 1
            }
        }
        
        while p2 < n {
            nums1[p1] = nums2[p2]
            p1 += 1
            p2 += 1
        }
    }
}
// @lc code=end

