
// 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。(l-26)

// 1. 双指针. 因为是升序, 依次遍历, 相等的置为 null, 第二次循环遍历遇见 null 的时候将下一个非 null 的元素
// 移至最前面的 null. 总共遍历两次数组, 时间复杂度为: O(n). 为开辟新的空间, 空间复杂度为: O(1).

var removeDuplicates = function(nums) {
  if (nums.length <= 1) {
    return nums.length;
  }
  for (let i = 1; i < nums.length; i++) { // 将 nums 数组相同的数字置为 null.
    if (nums[i] === nums[i - 1]) {
      let current = nums[i - 1];
      nums[i] = null;
      i++;
      while (nums[i] === current) {
        nums[i] = null;
        i++;
      }
      i--;
    }
  }
  let pointer = 1;
  for (let i = 1; i < nums.length; i++) { // 数组位置移动.
    while (nums[i] === null) {
      i++;
    }
    if (nums[i] !== undefined) { // 防止数组越界.
      nums[pointer] = nums[i];
      pointer += 1;
    }
  }
  return pointer;
};

// console.log(removeDuplicates([0, 0, 0, 0, 0]));

// 2. 双指针. 方法一中的第一次循环是多余的, 其实可以直接在第二个步骤中完成. 时间复杂度为: O(n). 空间复杂度为: O(1).

var removeDuplicates = function(nums) {
  if (nums.length <= 1) {
    return nums.length;
  }
  let pointer = 1;
  for (let i = 1; i < nums.length; i++) {
    while (nums[i] === nums[i - 1]) {
      i++;
    }
    if (nums[i] !== undefined) {
      nums[pointer++] = nums[i];
    }
  }
  return pointer;
}

// console.log(removeDuplicates([1,1,1,2,2,3,4,5,6,6,6]));

// 3. 官方题解优化. 去 while 循环.