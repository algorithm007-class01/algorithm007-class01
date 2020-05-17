class Solution {
public:
    int rob(vector<int>& nums) {
        int preMax = 0, curMax = 0;
        for (int num: nums) {
            int temp = curMax;
            curMax = max(preMax + num, curMax);
            preMax = temp;
        }
        return curMax;
    }
};
