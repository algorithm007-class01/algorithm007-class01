//153 - 寻找旋转排序数组中的最小值
//思路：由于升序（尽管部分升序,可以处理），考虑使用二分查找
class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
};
//时间复杂度：O(logn)  空间复杂度：O(1)