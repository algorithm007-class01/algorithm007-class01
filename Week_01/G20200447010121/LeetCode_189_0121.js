// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
var rotate = function(nums, k) {
    // nums.splice(0, 0, ...nums.splice(nums.length - k))
    while(k-- > 0) {
        nums.unshift(nums[pop])
    }
};

var rotate = function (nums, k) {
    if (!nums || nums.length <= 1 || k <= 0) return;
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}
function reverse(nums, start, end) {
    while(start < end) {
        let temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
} 