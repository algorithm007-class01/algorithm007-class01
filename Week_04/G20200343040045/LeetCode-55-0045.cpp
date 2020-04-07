#include <iostream>
#include <vector>

using namespace std;

/**
 * 题目：非负数组是否能跳跃到最后一个位置
 * solution: 使用贪心算法，从后向前判断
 *          时间复杂度为O(n),空间复杂度为O(1)
 * test cases:空数组，能够正常跳跃的位置[2,3,1,1,4]，不能正常跳跃的位置[3,2,1,0,4]
*/

class Solution {
   public:
    bool canJump(vector<int>& nums) {
        if (nums.size() == 0) return false;
        int pos = nums.size() - 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            };
        }
        return pos == 0;
    }
};
int main() {
    Solution solution = Solution();
    vector<int> t1;
    vector<int> t2{2, 3, 1, 1, 4};
    vector<int> t3{3, 2, 1, 0, 4};
    cout << "res1:" << solution.canJump(t1) << endl;
    cout << "res2:" << solution.canJump(t2) << endl;
    cout << "res3:" << solution.canJump(t3) << endl;
}