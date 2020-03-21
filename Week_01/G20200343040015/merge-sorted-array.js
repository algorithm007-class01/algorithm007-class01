/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    if(nums1.length>m) nums1.splice(m);
    if(nums1.length>n) nums2.splice(n);
    Array.prototype.push.apply(nums1,nums2);
    nums1 = nums1.sort((a,b) =>a-b);
}