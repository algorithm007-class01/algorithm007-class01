/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

/**
 * @description  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @example
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
   输出: [5,6,7,1,2,3,4]
    解释:
    向右旋转 1 步: [7,1,2,3,4,5,6]
    向右旋转 2 步: [6,7,1,2,3,4,5]
    向右旋转 3 步: [5,6,7,1,2,3,4]
 */
/**
 * @description  注意要点：k可能超出数组的长度    移动的位置应该是 k%n
 * @description  解决思路：从边界位置截取，在做拼接
 * @description  原数组操作js方法splice   可以做删除和插入   **做插入时候   splice(0,0,插入内容)   插入内容必须是item1,item2,item3
 */

var rotate = function(nums, k) {
    var n = nums.length;
    k%=n;
    var newValue = nums.splice(n-k)
    nums.splice(0,0,...newValue);
};