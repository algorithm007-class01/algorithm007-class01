/*
 * @lc app=leetcode.cn id=242 lang=swift
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if s.count != t.count {
            return false
        }
        var dic = [Character: Int]()
        for i in s {
            if let count = dic[i] {
                dic[i] = count+1
            }else{
                dic[i] = 1
            }
        }

        for j in t {
            if var count = dic[j] {
                count -= 1
                if count < 0 {
                    return false
                }
                dic[j] = count
            }else{
                return false
            }
        }

        for value in dic.values {
            if value > 0{
                return false
            }
        }
        return true
    }
}


// improve 
class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        guard s.count == t.count else { return false }
        
        var map = [Character: Int]()
        for char in s {
            map[char, default: 0] += 1
        }
        
        for char in t {
            map[char, default: 0] -= 1
        }
        
        return map.values.filter { $0 > 0 }.count == 0
    }
}

// improve 
// 因为长度一样可以在一次循环中将两个哈希表生成

class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        var sArray = Array(s).sorted()
        var tArray = Array(t).sorted()
        return String(sArray) == String(tArray)
    }
}

//improve

return s.sorted() == t.sorted()
// @lc code=end

