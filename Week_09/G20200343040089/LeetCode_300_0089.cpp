//	贪心策略+二分查找
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if (n < 2) return n;

        vector<int> tails(n,0);
        int end = 0;

        for (int x : nums) {
            int left = 0;
            int right = end;
            while (left != right) {
                int mid = (left + right) >> 1;
                if (tails[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } 
            tails[left] = x;
            if (left == end) end++;
        }
        return end;
    }
};