#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        
        // 反转所有元素
        reverse(nums, 0, nums.size() - 1);
        // 反转前k个元素
        reverse(nums, 0, k - 1);
        // 反转后n-k个元素
        reverse(nums, k, nums.size() - 1);
    }

    void reverse(vector<int>& nums, int start, int end) {
        while (start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

};

int main () {
    Solution s = Solution();
    vector<int> n = {1,2,3,4,5,6,7};
    s.rotate(n, 3);
    for(int i : n) {
        cout << i << ' ';  
    }
    cout << endl;

    return 0;
}