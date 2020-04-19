#include <iostream>
#include <vector>
using namespace std;

/**
 * 题目：搜索旋转排序数组
 * solution: 使用二分查找算法 修改二分查找算法的判断条件(判断向后规约的条件)
 *        时间复杂度为O(logN),空间复杂度为O(1)
 * test cases:空数组,[3,4,5,1,2]，[4,5,6,7,0,1,2]
*/

class Solution {
   public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // [0,mid]升序
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
                // [0,mid]存在旋转数组
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == right && nums[left] == target ? left : -1;
    }
};
int main() {
    Solution solution = Solution();
    vector<int> nums{4, 5, 6, 7, 0, 1, 2};
    int res = solution.search(nums, 0);
    cout << "res:" << res << endl;
}
