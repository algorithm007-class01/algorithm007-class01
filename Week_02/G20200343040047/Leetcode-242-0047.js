/**
 * 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 */
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  if (s.length != t.length) {
    return false;
  }
  var result = new Array(26);
  for (var i = 0; i < 26; i++) {
    result[i] = 0;
  }
  var aCode = "a".charCodeAt();
  for (var i = 0; i < s.length; i++) {
    result[s[i].charCodeAt() - aCode]++;
  }
  for (var r = 0; r < t.length; r++) {
    var tmpCode = t[r].charCodeAt() - aCode;
    result[tmpCode]--;
    if (result[tmpCode] < 0) {
      return false;
    }
  }
  return true;
};
