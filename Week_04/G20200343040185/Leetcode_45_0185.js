var jump = function(nums) {
  if (nums.length === 1) return 0;
  let sum = 0;
  for (let i = 0; i < nums.length; true) {
    if (i + nums[i] + 1 >= nums.length) return ++sum;
    let max = 0;
    let current = 0;
    for (let j = 1; j <= nums[i]; j++) {
      if (j + nums[j + i] > max) {
        current = j + i;
        max = nums[j + i] + j;
      }
    }
    sum++;
    i = current;
  }
  return sum;
};