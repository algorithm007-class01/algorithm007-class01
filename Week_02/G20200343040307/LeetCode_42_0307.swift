/*
 * @lc app=leetcode.cn id=42 lang=swift
 *
 * [42] 接雨水
 */

// @lc code=start
//  栈
class Solution {
    func trap(_ height: [Int]) -> Int {
        var ans = 0
        var stack = [Int]()
        for (index, high) in height.enumerated() {
            while !stack.isEmpty && high > height[stack.last ?? 0] {
                let current = height[stack.removeLast()]
                if stack.isEmpty {
                    break
                }
                let width = index - stack.last! - 1 
                ans += (min(high, height[stack.last!]) - current)*width
                
            }
            stack.append(index)
        }
        return ans
    }
}


// @lc code=end

class Solution {
    func trap(_ height: [Int]) -> Int {
        var ans = 0
        
        var leftIndex = 0
        var righIndex = height.count - 1
			// * 左右边界初始值为零，index 只能比较后加减 如果初始值为首位值，那么加减写在前面还能减少一次比较        
		var lefMax = height[0]
        var rigMax = height.last ?? 0
        
        while leftIndex < righIndex {
					// *  *
            if height[leftIndex] < height[righIndex] {
                if height[leftIndex] > lefMax {
                    lefMax = height[leftIndex]
                }else {
                    ans += lefMax - height[leftIndex]
                }
                leftIndex += 1
            }else{
                if height[righIndex] > rigMax {
                    rigMax = height[righIndex]
                }else {
                    ans += rigMax - height[righIndex]
                }
                righIndex -= 1
            }
        }
                
        return ans
    }
}

// 单个 level 代替两个边界最大值
class Solution {
      func trap(_ height: [Int]) -> Int {
        var level = 0
        var left = 0
        var right = height.count - 1
        var ans = 0

        while left < right {
            level = max(level, min(height[right], height[left]))
            if height[right] > height[left] {
                ans += level - height[left]
                left += 1
            }else {
                ans += level - height[right]
                right -= 1
            }
        }
        return ans
      }
}
