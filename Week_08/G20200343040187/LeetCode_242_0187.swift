// 242. 有效的字母异位词
/*
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。
 */

class Solution {
    func isAnagram(s: String, _ t: String) -> Bool {
        let sCharsFreq = Dictionary(s.map { ($0, 1) }, uniquingKeysWith: +)
        let tCharsFreq = Dictionary(t.map { ($0, 1) }, uniquingKeysWith: +)
        
        return sCharsFreq == tCharsFreq
    }
}

