/**
 * 26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @param {number[]} nums
 * @return {number}
 */
// 操作原有数组 去头增尾
var removeDuplicates = function(nums) {
  let item,
    length = nums.length;
  while (length > 0) {
    let num = nums[0];
    if (item != num) {
      item = num;
      nums.push(num);
    }
    nums.shift();
    length--;
  }
};
// 元素替换 控制数组长度
// var removeDuplicates = function(nums) {
//     let item,count = 0;
//     for (let i = 0; i < nums.length; i++) {
//         let num = nums[i];
//         if(item != num){
//             item = num;
//             nums[count] = num;
//             count++;
//         }
//     }
//     nums.length = count;
// };
