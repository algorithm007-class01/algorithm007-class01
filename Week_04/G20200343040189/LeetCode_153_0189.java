//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
// 请找出其中最小的元素。
// 你可以假设数组中不存在重复元素。
//
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
// 这个旋转后的数组保证了有左右边界，可以通过下标访问元素，它的两部分都是单调增的
// 所以可以使用二分查找
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        // 设置左右边界
        int left = 0;
        int right = len - 1;
        // 右边边界元素与左边边界元素比较大小
        if (nums[right] > nums[left]) {
            return nums[left];
        }
        while (left <= right) {
            // 找到数组最中间元素
            int mid = (left + right) / 2;
            // 比较中间元素与之后一个元素的大小，如果大于则返回后一个元素
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            // 比较中间元素与之前一个元素的大小，如果小于则返回中间元素
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            // 比较中间元素与最左边元素的大小，如果大于则将左边边界移动到中间元素之后
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }
            // 比较中间元素与最左边元素的大小，如果小于则将右边边界移动到中间元素之前
            if (nums[mid] < nums[0]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
