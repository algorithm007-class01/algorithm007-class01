var canJump = function(nums) {
  let result = nums.length - 1;
  for (let i = nums.length - 2; i >= 0; i--) {
    if (i + nums[i] >= result) {
      result = i;
    }
  }
  return result === 0 ? true : false;
};