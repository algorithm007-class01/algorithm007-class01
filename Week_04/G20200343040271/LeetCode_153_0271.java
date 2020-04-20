/*
153. 寻找旋转排序数组中的最小值
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array

假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。你可以假设数组中不存在重复元素。
示例 1:
    输入: [3,4,5,1,2]
    输出: 1
示例 2:
    输入: [4,5,6,7,0,1,2]
    输出: 0
*/

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[]{2,1}));;
    }

    /**
     * 二分搜索， 时间复杂度为O(logN)，空间复杂度为O(1)。
     * 为什么可以使用二分搜索：旋转排序数组(以升序为例)，即数组中分为有序的两部分，前部分有序元素，比后部分有序元素大。
     * left、…… 、A、mid、B 、…… 、right,
     * 一旦出现了左边元素小于相邻右边元素，则即为两个有序元素的分隔位置。分隔点即为最小值
     *
     * 思路：
     * if(mid>B),则B——>right有序部分中的最小值为B
     * if(mid<A),则mid——>A),则mid——>right有序部分中的最小值为mid
     * 以上判断不成功，则说明最小值落在left——>mid-1或mid+1——>right之间，
     * if(left < mid),则左边有序，那么右边肯定存在最小值，left = mid + 1
     * if(right > mid),则右边有序，那么左边肯定存在最小值，right = mid - 1
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        int left = 0,right = nums.length -1, mid ;
        if(nums[right] >= nums[0]) return nums[0];
        while (left <= right){
            mid = (left + right)/2;
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            if(nums[mid] < nums[mid-1]) return nums[mid];
            if(nums[left] < nums[mid]) left = mid + 1;
            if(nums[right] > nums[mid]) right = mid -1;
        }
        return -1;
    }
}