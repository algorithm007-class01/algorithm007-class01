/**
 * 两数之和
 * 1. 暴力解法
 */

var twoSum1 = function(nums, target) {
  let a = []
  let len = nums.length
  for (let i = 0; i < len; i++) {
    for (let j = i + 1; j < len; j++) {
      if (nums[i] + nums[j] === target) {
        a[0] = i
        a[1] = j
        break
      }
    }
  }
  return a
}


/**
 * 利用hash表记录查询过程中target和数组元素的差值，key是差值，value是元素在数组中的下标
 * 每次遍历前都从hash表中查询是否存在，若存在则直接返回结果，不存在继续遍历直到结束
 */
var twoSum2 = function(nums, target) {
  const map = new Map()
  for (let i = 0; i < nums.length; i++) {
    let r = target - nums[i]
    if (map.has(r)) {
      return [map.get(r), i]
    }
    map.set(nums[i], i)
  }
};



