/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 * 
 * @description  通过从后往前便利，把最大的数先插入。在控制对应的索引移动
 */
var merge = function(nums1, m, nums2, n) {
    //插入位置
    var insertPosition = m+n-1;
    m--;n--;
    while(n>=0){
        nums1[insertPosition--] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
    }
};