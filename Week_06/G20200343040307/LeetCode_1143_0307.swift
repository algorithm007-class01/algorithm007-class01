/*
 * @lc app=leetcode.cn id=1143 lang=swift
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    func longestCommonSubsequence(_ text1: String, _ text2: String) -> Int {
        var chars1 = Array(text1)
        var chars2 = Array(text2)
        var ans = [[Int]](repeating: [Int](repeating: 0, count: text1.count+1),count: text2.count+1)
      	// char2.indices 数组的下标集合
        for sec in 0..<chars2.count {
            for fir in 0..<chars1.count {
              	// 第一次使用的字符串下标，但是超出时间限制。所以应该是每次根据偏移量读取对应字符的时候需要较长的处理时间
                // let one = text1.index(text1.startIndex, offsetBy: fir-1)
                // let two = text2.index(text2.startIndex, offsetBy: sec-1)
                if chars1[fir] == chars2[sec] {
                    ans[sec+1][fir+1] = ans[sec][fir] + 1
                }else{
                    ans[sec+1][fir+1] = max(ans[sec+1][fir],ans[sec][fir+1])
                }
            }
        }

        return ans[text2.count][text1.count]
    }
}
// @lc code=end

