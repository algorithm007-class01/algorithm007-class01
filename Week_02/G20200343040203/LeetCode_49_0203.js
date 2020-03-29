/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    const map = {};
  
    for (const str of strs) {
      const sortStr = str.split('').sort().join('');
      (map[sortStr] || (map[sortStr] = [])).push(str);
    }
  
    return Object.keys(map).map(key => map[key]);
  };