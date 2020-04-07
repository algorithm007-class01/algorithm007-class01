/*
33. 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。

示例 1:
    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4
示例 2:
    输入: nums = [4,5,6,7,0,1,2], target = 3
    输出: -1
*/


public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{5,1,3},3));;
    }

    /**
     * 二分查找：
     * left、……、mid-1、mid、mid+1、……、right
     * if(left <= mid) 左边有序
     *      if（left <= target && target < mid) right = mid - 1； // 目标值在左侧有序元素中
     *      else left = mid + 1; // 目标值在右侧无序元素中
     * else 右边有序
     *         if(mid < target && target <= right) left = mid + 1; // 目标值在右侧有序元素中
     *         else right = mid - 1; // 目标值在左侧无序元素中
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){ // <=匹配只有两个数场景
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}