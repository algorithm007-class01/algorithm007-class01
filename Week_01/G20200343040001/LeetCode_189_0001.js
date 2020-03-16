/**
 * 旋转数组
 */

/**
 * 暴力解法
 */
var rotate1 = function(nums, k) {
  let pre;
  for (let i = 0; i < k; i++) {
      pre = nums[nums.length - 1];
      for (let j = 0; j < nums.length; j++) {
          let temp = nums[j];
          nums[j] = pre;
          pre = temp;
      }
  }
};

/**
 * 一句js解决
 */
var rotate = function(nums, k) {
  if (!nums) return
  nums.splice(0, 0, ...nums.splice(nums.length - k, k))
};


