/**
 * 189. 旋转数组 https://leetcode-cn.com/problems/rotate-array/
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// var rotate = function(nums, k) {
//     let lenght = nums.length;
//     while(k > 0){
//         let item = nums[lenght-1];
//         nums.unshift(item);
//         nums.pop();
//         k--;
//     }
// };

// var rotate = function(nums, k) {
//     let lenght = nums.length;
//     while(k > 0){
//         let item = nums[lenght-1];
//         nums.unshift(item);
//         k--;
//     }
//     nums.length = lenght;
// };

var rotate = function(nums, k) {
  let lenght = nums.length,
    end = length - 1;
  while (k > 0 && k != lenght) {
    if (lenght > k) {
      let item = nums[k - 1];
      nums[k - 1] = nums[end];
      nums[k - 1] = item;
    } else {
      nums[end] = nums[k - lenght - 1];
    }
    if (lenght - k > 0) {
      nums[head] = nums[head + k];
      nums[head + k] = item;
      head;
    }
    k--;
  }
};
