/*
 * @lc app=leetcode.cn id=49 lang=swift
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var anaDic = [String: [String]]()
        for (index , str) in strs.enumerated() {
            let sortStr = String(str.sorted())
            if let _ = anaDic[sortStr] {
                anaDic[sortStr]?.append(strs[index])
            }else {
                anaDic[sortStr] = [strs[index]]
            }
            
        }
        var res = [[String]]()
        for item in anaDic.values {
            res.append(item)
        }
        return res

    }
}


//  利用 Swift 的高阶函数 精简代码
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var dict = [String: [String]]()
        strs.forEach {
            let s = String($0.sorted())
            dict[s] = (dict[s] == nil) ? [$0] : dict[s]! + [$0]
        }
        return dict.map({$0.value})
        }
}


// 对于字典部分 特殊的写法
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        guard strs.count != 0 else { return [] }
        
        // bond sorted key with its group
        var dict = [String:[String]]()
        
        for str in strs {
            let sorted = String(str.sorted())
			 // 或者 dict[sorted, default: [String]() ].append(str)
            dict[sorted, default:[]].append(str)
        }
        return Array(dict.values)
    }
}

// 更加通用的方法，多了一个转化成 hash 值得方法
class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        var resultGroups: [Int: [String]] = [:]
        for s in strs {
            let hashValue = getAnagramsHash(s)
            (resultGroups[hashValue] == nil) ? resultGroups[hashValue] = [s] : resultGroups[hashValue]?.append(s)
        }
        return Array(resultGroups.values)
    }
    
    func getAnagramsHash(_ s: String) -> Int {
        var hasher = Hasher()
        hasher.combine(s.sorted())
        return hasher.finalize()
    }
}
// @lc code=end

