/**
* Summary:ind-minimum-in-rotated-sorted-array
* Parameters:
*   nums: source array
* Return: min number
*/
class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        int mid = 1;
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            mid = left + ((right - left) >> 1);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
};

