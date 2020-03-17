/**
 * 189. 旋转数组 https://leetcode-cn.com/problems/rotate-array/
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 时间复杂度 O(n) 空间复杂度 O(1)
var rotate_1 = function(nums, k) {
  // 数组长度
  let lenght = nums.length;
  // 数组由右向左移动，顺序是从尾向头环形处理
  while (k > 0) {
    let item = nums[lenght - 1];
    // 将尾项添加到首项
    nums.unshift(item);
    // 将尾项删除掉
    nums.pop();
    k--;
  }
};
// 时间复杂度 O(n) 空间复杂度 O(1)
var rotate_2 = function(nums, k) {
  // 获取需要移动的位置数(取余数)
  k = k % nums.length;
  // start 代表发起移动的元素下标，count 代表已经移动位置的元素的个数
  for (let start = 0, count = 0; count < nums.length; start++) {
    // current 当前移动位置元素的下标
    let current = start;
    // 当前移动位置元素
    let item = nums[start];
    // 需要先执行，在做判断
    do {
      // 需要移动到目标位置的下标
      let next = (k + current) % nums.length;
      // 将目标位置存在的元素进行存储
      let nextItem = nums[next];
      // 目标位置元素替换为当前移动的元素
      nums[next] = item;
      // 将下一个需要移动的元素进行存错
      item = nextItem;
      // 将下一个需要移动的元素下标赋值给
      current = next;
      // 记录已经移动位置的元素个数
      count++;
    } while (current != start); // 如果当前移动位置元素的下标 等于 发起移动的元素下标 说明需要进行下一个元素发起移动
  }
};
