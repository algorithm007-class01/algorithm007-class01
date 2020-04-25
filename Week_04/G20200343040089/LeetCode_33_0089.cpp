/**
* Summary:search-in-rotated-sorted-array
* Parameters:
*   nums: source array
*	target: target number
* Return: target index
*/
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        int mid = 1;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if ((nums[0] <= nums[mid]) && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == right && nums[left] == target) ? left : -1;
    }
};