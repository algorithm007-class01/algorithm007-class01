/**
 * 1. 两数之和 https://leetcode-cn.com/problems/two-sum/
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

let twoSum = (nums, target) => {
  let numMap = {};
  for (let i = 0; i < nums.length; i++) {
    let item = nums[i];
    let beforIndex = numMap[target - item];
    if (numMap.hasOwnProperty(target - item) && beforIndex !== i) {
      return [beforIndex, i];
    } else {
      numMap[item] = i;
    }
  }
  return [];
};

// 占用少内存，时间不可观
// var twoSum = function(nums, target) {
//     let index;
//     for (let i = 0; i<nums.length; i++) {
//         index = nums.indexOf(target-nums[i]);
//         if( i !== index && index !== -1){
//             return [i,index]
//         }
//     }
//     return [];
// }
