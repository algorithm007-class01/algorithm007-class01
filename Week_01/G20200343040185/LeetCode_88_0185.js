// 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。(l-88)

// 1. 暴力法. 直接将两个数组合并, 然后排序, 这样假设数组 nums1 的长度为 k, 时间复杂度为: O(klogk). 空间复杂度为: O(1).
var merge = function(nums1, m, nums2, n) {
  nums1.splice(m, 0, ...nums2.splice(0, n));
  nums1.splice(m + n, nums1.length);
  nums1.sort((x, y) => x - y);
};

// 2. 双指针. 在 nums1 和 nums2 的 m, n 处设置两个指针, 比较两个数的大小, 较大的移至 nums1 的尾部处.
// 这样只要把要移动的项遍历一次即可. 时间复杂度为: O(m + n). 空间复杂度为: O(1), 仅添加了两个指向数组某处
// 的指针.
var merge = function(nums1, m, nums2, n) {
  let p1 = m - 1;
  let p2 = n - 1;
  for (let i = m + n - 1; i >= 0; i--) {
    if ((nums1[p1] > nums2[p2] || p2 === -1) && p1 !== -1) {
      nums1[i] = nums1[p1]; // p1-- 可以写在这里.
      p1--;
    } else {
      nums1[i] = nums2[p2]; // p2-- 可以写在这里.
      p2--;
    }
  }
}

// leetcode most votes 上的题解参照其代码重写.