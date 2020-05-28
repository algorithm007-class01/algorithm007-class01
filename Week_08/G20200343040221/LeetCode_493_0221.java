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

package leetcode.editor.cn;

// 493. 翻转对
public class ReversePairs_493 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 归并
    public int reversePairs(int[] nums) {
        return mergeCount(nums, 0, nums.length - 1);
    }
    private int mergeCount(int[] nums, int begin, int end) {
        if (begin >= end) {
            return 0;
        }

        int mid = begin + ((end - begin) >> 2);
        int count = mergeCount(nums, begin, mid) + mergeCount(nums, mid + 1, end);
        for (int i = begin, j = mid + 1; i <= mid; i++) {
            // i-1的终止点和终止结果可以直接给i用，i只需要计算出自己比i-1增长的那部分
            // 下面这个while循环直接使用了i-1的j（也就是i-1的终止点）
            // i在i-1的结果之上继续推动j向后走
            while (j <= end && nums[i] > (2 * ((long) nums[j]))) {
                j++;
            }
            // 终止结果也是跟j有关的，所以i也复用了i-1的终止结果
            // 如果i没有推动j向后走，那么i的终止结果和i-1是一样的
            count += j - (mid + 1);
        }

        mergeSort(nums, begin, mid, end);

        return count;
    }
    private void mergeSort(int[] nums, int begin, int mid, int end) {
        int i = begin;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - begin + 1];
        while (i <= mid && j <= end) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, begin, temp.length);
    }

    // 两层循环（超时）
    public int reversePairs1(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (num > 2 * ((long) nums[j])) {
                    r += 1;
                }
            }
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
