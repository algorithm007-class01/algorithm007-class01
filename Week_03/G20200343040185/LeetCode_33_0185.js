/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
// 先用二分法找到数组中的最大数, 判断 target 在左子数组还是右子数组, 
// 再用一次二分法在其中寻找 target.
var search = function(nums, target) {
  if (nums.length === 0) return -1;
  if (nums.length === 1) return nums[0] === target ? 0 : -1;
  let end = nums.length - 1;
  let start = 0;
  let mid;
  while (start <= end) {
    mid = ~~((start + end) >> 1);
    if (nums[mid] === target) return mid;
    if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) break;
    if (nums[mid] >= nums[0]) start = mid + 1;
    if (nums[mid] < nums[0]) end = mid - 1;
  }
  if (nums[mid] > target) {
    start = mid + 1;
    end = nums.length - 1;
  } else {
    start = 0;
    end = mid - 1;
  }
  while (start <= end) {
    mid = ~~((start + end) >> 1);
    if (nums[mid] === target) return mid;
    if (nums[mid] < target) start = mid + 1;
    if (nums[mid] > target) end = mid - 1;
  }
  return -1;
};

var search = function(nums, target) {
  return nums.indexOf(target);
}