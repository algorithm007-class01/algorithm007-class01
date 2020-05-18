/*
 * @lc app=leetcode.cn id=91 lang=swift
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    func numDecodings(_ s: String) -> Int {
        guard s.count > 0 else {
            return 0
        }
        
        let digits = Array(s).map { Int(String($0))! }
        var dp = Array(repeating: 0, count: digits.count + 1)
        dp[0] = 1
        dp[1] = digits[0] == 0 ? 0 : 1
        for i in stride(from: 2, through: digits.count, by: 1) {
            dp[i] += (digits[i - 1] > 0 ? dp[i - 1] : 0)
            let num = digits[i - 2] * 10 + digits[i - 1]
            dp[i] += ((num >= 10 && num <= 26) ? dp[i - 2] : 0)
        }
        
        return dp[digits.count]
    }
}

class Solution {
    func numDecodings(_ s: String) -> Int {
        guard s.count > 0 && !s.starts(with: "0") else{
            return 0
        }
        var nums = Array(s)
        var curr = 1  
        var pre = 1
        for i in 1..<nums.count {
            let tmp = curr
            if nums[i] == "0" {
                if nums[i-1] == "1" || nums[i-1] == "2" {
                    curr = pre
                }else{
                    return 0
                }
            }else if nums[i-1] == "1" {
                curr += pre
            }else if nums[i-1] == "2" && "1" <= nums[i] && nums[i] <= "6" {
                curr += pre
            }
            pre = tmp
        }
        return  curr
    }
}

class Solution {
    func numDecodings(_ s: String) -> Int {
    if s.isEmpty || s[s.startIndex] == "0" { return 0 }
    if s.count == 1 { return 1 }
    var count = 1, last = 1
    var i = s.index(after: s.startIndex)
    while i < s.endIndex {
        var cur = 0
        if s[i] > "0" {
            cur += count
        }
        if s[s.index(before: i)] == "1" || (s[s.index(before: i)] == "2" && s[i] <= "6") {
            cur += last
        }
        last = count
        count = cur
        if last == 0 {
            return 0
        }
        i = s.index(after: i)
    }
    return count
    }
}


// @lc code=end

