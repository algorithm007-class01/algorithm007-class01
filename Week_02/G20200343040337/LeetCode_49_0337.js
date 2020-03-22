/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (61.08%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    58.4K
 * Total Submissions: 95.3K
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
  var isAnagram = function(s, t) {
    if (s.length != t.length) return false;
    let arr = [];
    let a = 'a'.charCodeAt(0);
    for (let i = 0; i < s.length; i++) {
      if (!arr[s.charCodeAt(i) - a]) arr[s.charCodeAt(i) - a] = 0;
      arr[s.charCodeAt(i) - a]++;
    }
    for (let i = 0; i < t.length; i++) {
      if (!arr[t.charCodeAt(i) - a]) arr[t.charCodeAt(i) - a] = 0;
      arr[t.charCodeAt(i) - a]--;
      if (arr[t.charCodeAt(i) - a] < 0) return false;
    }
    return true;
  }

  let result = [];
  for (let i = 0; i < strs.length; i++) {
    let isIn = false;
    for (let j = 0; j < result.length; j++) {
      if (isAnagram(result[j][0], strs[i])) {
        result[j].push(strs[i]);
        isIn = true;
        break;
      }
    }
    if (!isIn) {
      result.push([strs[i]]);
    }
  }

  return result;
};
// @lc code=end

