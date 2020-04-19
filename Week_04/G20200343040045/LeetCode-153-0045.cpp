#include <iostream>
#include <vector>
using namespace std;

/**
 * 题目：寻找旋转数组的最小值
 * solution: 使用二分查找算法 
 *        时间复杂度为O(logN),空间复杂度为O(1)
 * test cases:空数组,[3,4,5,1,2],[4,5,6,7,0,1,2]
*/

class Solution {
   public:
    int findMin(vector<int>& nums) {
        if (nums.size() == 0) throw "数组长度为0";
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
};
int main() {
    Solution solution = Solution();
    vector<int> nums{4,5,6,7,0,1,2};
    int res = solution.findMin(nums);
    cout << "res:" << res << endl;
}