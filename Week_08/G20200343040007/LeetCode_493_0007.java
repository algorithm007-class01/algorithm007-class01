
//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        int size = nums.length;
        if (size < 2) return 0;
        return mergeSort(0, size - 1, nums);
    }

        private int mergeSort(int l, int r, int[] nums) {
        if (l >= r) return 0;
        int mid = l + (r - l >>> 1);
        int count = mergeSort(l, mid, nums) + mergeSort(mid + 1, r, nums);
        int index = mid + 1;
        for (int i = l; i <= mid; ++i)
            while (index <= r && ((nums[i] >> 1) + (nums[i] & 1)) > nums[index]) {
                count += mid - i  + 1;
                index++;
        }
        merge(l, mid, r, nums);
        return count;
    }

    private void merge(int l, int mid, int r, int[] nums) {
        int[] result = new int[r - l + 1];
        int index = 0;
        int i = l, j = mid + 1;
        while (i <= mid && j <= r)
            result[index++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while (j <= r) result[index++] = nums[j++];
        while (i <= mid) result[index++] = nums[i++];
        System.arraycopy(result, 0, nums, l, result.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
