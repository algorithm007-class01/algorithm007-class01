/**
 * 1. 两数之和 https://leetcode-cn.com/problems/two-sum/
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// 时间复杂度 O(n) 空间复杂度 O(n) 开辟了新空间
let twoSum_1 = (nums, target) => {
  // 创建一个map 用来存储数组每一项对应满足条件的值(key)和当前数组项的下标(value)
  let numMap = {};
  // 循环当前数组
  for (let i = 0; i < nums.length; i++) {
    // 获取当前数组项
    let item = nums[i];
    // 在map集合中查找满足条件的下标
    let beforIndex = numMap[target - item];
    // 如果满足条件的值存在 并且对应的数组项下标不是当前项的下标
    if (numMap.hasOwnProperty(target - item) && beforIndex !== i) {
      // 返回满足条件的下标
      return [beforIndex, i];
    } else {
      // 为map添加满足当前项及其下标
      numMap[item] = i;
    }
  }
  // 没有满足条件时返回空数组
  return [];
};

// 时间复杂度 O(n) 空间复杂度 O(n)
var twoSum_2 = function(nums, target) {
  // 用来存储满足条件的另一个值得下标
  let index;
  // 循环当前数组
  for (let i = 0; i < nums.length; i++) {
    // 获取满足当前项条件的另一项的下标
    index = nums.indexOf(target - nums[i]);
    // 如果满足当前项条件的另一项也在这个数组中 并且 满足条件项的下标不为当前项的下标
    if (i !== index && index !== -1) {
      // 直接返回满足条件的下标集合
      return [i, index];
    }
  }
  // 没有满足条件时返回空数组
  return [];
};
