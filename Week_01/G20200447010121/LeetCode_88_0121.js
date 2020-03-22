// 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
// 说明:
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
var merge = function (nums1, m, nums2, n) {
    // 1.
    // nums1.splice(m, nums1.length, ...nums2)
    // nums1.sort((a, b) => a - b)

    // 2.
    nums1.splice(m)
    m--
    n--
    while (m >= 0 && n >= 0) {
        if (nums1[m] > nums2[n]) {
            m--
        } else if (nums1[m] >= nums2[n - 1]) {
            nums1.splice(m + 1, 0, ...nums2.splice(n--))
        } else {
            n--
        }
    }
    nums1.splice(m + 1, 0, ...nums2)
};