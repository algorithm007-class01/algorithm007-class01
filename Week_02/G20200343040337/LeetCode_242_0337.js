/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length != t.length) return false;
  let arr = [];
  let a = 'a'.charCodeAt(0);
  
  for (let i = 0; i < s.length; i++) {
    if (!arr[s.charCodeAt(i) - a]) arr[s.charCodeAt(i) - a] = 0
    arr[s.charCodeAt(i) - a]++;
  }

  for (let i = 0; i < t.length; i++) {
    if (!arr[t.charCodeAt(i) - a]) arr[t.charCodeAt(i) - a] = 0
    arr[t.charCodeAt(i) - a]--;
    if (arr[t.charCodeAt(i) - a] < 0) return false;
  }
  return true;
};
// @lc code=end

