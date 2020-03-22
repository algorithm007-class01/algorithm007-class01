/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
// 利用js特性，尾部弹出，头部插入
var rotate1 = function (nums, k) {
    if (!nums || nums.length <= 1 || k <= 0) return;
    k %= nums.length;
    for (let i = 0; i < k; i++) {
        nums.unshift(nums.pop());
    }
};

//暴力
var rotate2 = function (nums, k) {
    if (!nums || nums.length <= 1 || k <= 0) return;
    k %= nums.length;
    for (let i = 0; i < k; i++) {
        let rValue = nums[nums.length - 1];//last
        for (let j = 0; j < nums.length; j++) {
            let tmp = nums[j];
            nums[j] = rValue;
            rValue = tmp;
        }
    }
};

//局部反转法
var rotate3 = function (nums, k) {
    if (!nums || nums.length <= 1 || k <= 0) return;
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}
function reverse(nums, start, end) {
    while (start < end) {
        let temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}