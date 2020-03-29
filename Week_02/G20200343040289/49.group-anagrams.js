/*
 * @lc app=leetcode id=49 lang=javascript
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (53.02%)
 * Likes:    2666
 * Dislikes: 154
 * Total Accepted:    507.8K
 * Total Submissions: 956K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 *
 * Note:
 *
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 *
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
  if (!strs || strs.length === 0) return [];

  let map = new Map();
  let count = new Array(26);

  let a = 'a'.charCodeAt(0);

  for (let s of strs) {
    count.fill(0);

    for (let c of s) count[c.charCodeAt(0) - a]++;

    let key = '';
    for (let i = 0; i < 26; i++) {
      key += '#';
      key += count[i];
    }
    if (!map.has(key)) map.set(key, []);
    map.get(key).push(s);
  }

  return Array.from(map.values());
};
// @lc code=end
