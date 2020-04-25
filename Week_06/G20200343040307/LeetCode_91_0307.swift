/*
 * @lc app=leetcode.cn id=91 lang=swift
 *
 * [91] 解码方法
 */

// @lc code=start
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

