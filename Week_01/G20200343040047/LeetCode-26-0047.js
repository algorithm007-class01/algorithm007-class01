/**
 * 26. 删除排序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @param {number[]} nums
 * @return {number}
 */
// while 循环处理数组去头增尾 时间复杂度 O(n) 空间复杂度 O(1)
var removeDuplicates_1 = function(nums) {
  // 定义数组项用来判断是否为重复项，数组长度
  let item,
    length = nums.length;
  // while 循环处理
  while (length > 0) {
    // 每次获取数组第一项
    let num = nums[0];
    // 判断当前数组第一项是否与所存储项是否相等
    if (item != num) {
      // 不相等，数组第一项赋值给存储项，并将当前第一项添加到数组尾部
      item = num;
      nums.push(num);
    }
    // 去掉数组第一项
    nums.shift();
    // length进行下次比较
    length--;
  }
};
// 快慢双指针 时间复杂度  O(n) 空间复杂度 O(1)
var removeDuplicates_2 = function(nums) {
  // 定义数组项用来判断是否为重复项，记录数组非重复项的个数
  let item,
    count = 0;
  // for 循环处理
  for (let i = 0; i < nums.length; i++) {
    // 获取数组当前项
    let num = nums[i];
    // 判断数组当前项与存储项是否相等
    if (item != num) {
      // 如果不相等 将数组当前项赋值给存储变量
      item = num;
      // 将此项添加到数组非重复项下标所在位置
      nums[count] = num;
      // 将非重复项个数加一
      count++;
    }
  }
  // 截取非重复项个数长度的数组
  nums.length = count;
};
