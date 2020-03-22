/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 解法
 * 1.双指针遍历
 * 2.利用数组的方法进行元素移动
 */


/**
 * 双指针解法1
 */
var moveZeroes1 = function(nums) {
  if (!nums) return
  let j = 0
  for (let i = 0, len = nums.length; i < len; i++) {
    if (!!nums[i]) {
      let tmp = nums[i]
      nums[i] = nums[j]
      nums[j++] = tmp
    }
  }
};

/**
 * 双指针解法2
 */
var moveZeroes2 = function(nums) {
  if (!nums) return
  let j = 0
  let len = nums.length
  for (let i = 0; i < len; i++) {
    if (!!nums[i]) {
      nums[j++] = nums[i]
    }
  }
  for (let i = j; i < len; i++) {
    nums[i] = 0
  }
};

/**
 * 利用数组的方法进行元素移动 -- 不推荐
 */
var moveZeroes3 = function(nums) {
  if (!nums) return
  let count = 0
  let len = nums.length
  for (let i = 0; i < len - count; i++) {
    if (!nums[i]) {
      nums.push(nums.splice(i, 1))
      count++
      i--
    }
  }
};
