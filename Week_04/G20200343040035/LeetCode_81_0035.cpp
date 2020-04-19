class Solution {
public:
    int search(vector<int>& nums, int target) {
    int left = 0;
    int right = (int)nums.size() - 1;
    while (left <= right) {
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] > nums[left]) {
            //说明左半部分是单调递增的7 8 9 0 1
            if (target >= nums[left] && target < nums[mid]) {//7 8
                right = mid - 1;
            }else{//0 1
                left = mid + 1;
            }
        }else if (nums[mid] < nums[left]) {
            //说明右半部分是单调递增的7 8 9 0 1 2 3 4 5
            if (target > nums[mid] && target <= nums[right]) { //2 3 4 5
                left = mid + 1;
            }else{//7 8 9 0
                right = mid - 1;
            }
        }else{
            //[3,1] target = 1 nums[mid] = 3 不是我们需要的，且left = mid = 0，所以left也不是，所以过滤left->left++
            left++;
        }
    }
    return false;
}
};