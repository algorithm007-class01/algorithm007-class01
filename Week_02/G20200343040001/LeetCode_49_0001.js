/**
 * 1. 对数组中元素进行排序
 * 2. 以元素为key，如果是key相同的话，就归为一类
 */
var groupAnagrams = function(strs) {
  const map = new Map()
  for (let i = 0; i < strs.length; i++) {
    const tmp = strs[i].split('').sort().join('')
    if (map.has(tmp)) {
      const t = map.get(tmp)
      map.set(tmp, [...t, strs[i]])
    } else {
      map.set(tmp, [strs[i]])
    }
  }
  return [...map.values()]
};