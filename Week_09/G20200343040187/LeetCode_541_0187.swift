// 541. 反转字符串 II
/*
给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 
示例:
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
 
提示：
该字符串只包含小写英文字母。
给定字符串的长度和 k 在 [1, 10000] 范围内。
 */

class Solution {
    func reverseStr(_ s: String, _ k: Int) -> String {
          var chars = [Character](s.characters), res = [Character]()
    
          if k < 0 {
              fatalError("Invalid k")
          }
    
          for i in stride(from: 0, to: chars.count, by: 2 * k) {
              print(i)
      
              if chars.count < i + k {
                  res += chars[i..<chars.count].reversed()
                  break
              }
      
              res += chars[i..<i + k].reversed()
      
              if chars.count < i + 2 * k {
                  res += chars[i + k..<chars.count]
                  break
              }
      
              res += chars[i + k..<i + 2 * k]
          }
    
          return String(res)
      }
}

