//300. 最长上升子序列

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int *tails = new int[nums.size()];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) >> 1;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }
};