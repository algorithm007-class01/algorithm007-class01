

// MARK: LeetCode 49.字母异位词分组
/*
    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    示例:
    输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    说明：
    所有输入均为小写字母。
    不考虑答案输出的顺序。
*/
class Solution {
   func groupAnagrams(_ strs: [String]) -> [[String]] {
       if strs.count == 0 { return [] }
       var result = [String: [String]]()
       for str in strs {
           let sort_str = String(Array(str).sorted())
           if !result.keys.contains(sort_str) {
               result[sort_str] = [String]()
           }
           result[sort_str]?.append(str)
       }
       return Array(result.values)
   }
}
