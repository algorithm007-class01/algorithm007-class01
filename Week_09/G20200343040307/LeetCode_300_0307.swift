/*
 * @lc app=leetcode.cn id=300 lang=swift
 *
 * [300] 解码方法
 */

// @lc code=start
class Solution {
    func lengthOfLIS(_ nums: [Int]) -> Int {
        var ans = [Int](repeating: 1, count: nums.count)
        for i in 0..<nums.count {
            for j in 0..<i {
                if nums[j] < nums[i]{
                    ans[i] = max(ans[i], ans[j]+1)
                }   
            }
        }
				// 错误 ans 并不是递增，是需要满足另外条件的最大值
        return  ans.max() ?? 0
    }
}

class Solution {
    func lengthOfLIS(_ nums: [Int]) -> Int {
        var ans = [Int]()
        for num in nums {
						// 如遇到【0】出错，在下面加了一个 i >= ans.count
            if num > ans.last ?? 0 {
                ans.append(num)
            }else{
                var i = 0
                var j = ans.count-1
                while i < j {
                    var mid = (i+j)/2
										// 错误一： ans 和 num 比较
                    if ans[mid] < num {
                        i = mid+1
                    }else{
                        j = mid
                    }
                }
                if i >= ans.count {
                    ans.append(num)
                }else{
                    ans[i] = num
                }       
            }
        }
        return  ans.count
    }
}

// @lc code=end

