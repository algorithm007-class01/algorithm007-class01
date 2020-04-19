//45 - 跳跃游戏II
//思路：贪心算法
class Solution {
public:
    int jump(vector<int>& nums) {
        int step = 0, end = 0, maxPos = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            maxPos = max (maxPos, nums[i] + i);
            if (i == end) end = maxPos, step++;
        }
        return step;
    }
};
//时间复杂度：O(n)  空间复杂度：O(1)