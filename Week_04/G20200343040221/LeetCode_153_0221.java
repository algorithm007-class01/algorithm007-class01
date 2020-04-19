/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (50.17%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    40.5K
 * Total Submissions: 80.5K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 你可以假设数组中不存在重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 
 * 示例 2:
 * 
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 
 */

// @lc code=start
class Solution {
    // 旋转拼接后，拼接点左边的元素是数组中最大的元素，右边的元素是数组中最小的元素
    // 拼接点左边都大于第一个元素，拼接点右边的元素都小于第一个元素
    // 所以在使用二分查找算法时：
    //  中间点如果大于等于第一个元素，那么就在中间点右侧查找
    //  中间点如果小于第一个元素，那么就在中间点左侧查找
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int startValue = nums[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < startValue && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] >= startValue) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
// @lc code=end

