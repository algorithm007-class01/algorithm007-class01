// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
var rotate = function(nums, k) {
    // nums.splice(0, 0, ...nums.splice(nums.length - k))
    while(k-- > 0) {
        nums.unshift(nums[pop])
    }
};