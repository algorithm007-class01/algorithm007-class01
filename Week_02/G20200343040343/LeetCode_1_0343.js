/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (61.14%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    58.5K
 * Total Submissions: 95.5K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  // 1. 先所有元素排序，放入哈希表
  const sortedStrs = strs.map(str => str.split('').sort().join(''))
  const map = new Map()
  for (let i = 0; i < sortedStrs.length; i++) {
    if (!map.get(sortedStrs[i])) {
      map.set(sortedStrs[i], [])
    }
    map.set(sortedStrs[i], [...map.get(sortedStrs[i]), strs[i]])
  }
  const res = []
  for (let val of map.values()) {
    res.push(val)
  }
  return res
};
// @lc code=end

