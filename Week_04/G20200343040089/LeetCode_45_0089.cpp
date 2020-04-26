/**
* Summary:jump-game
* Parameters:
*   nums: jump value sequene
* Return: jump times
*/
class Solution {
public:
	int jump(vector<int>& nums) {
		int ans = 0;
		int end = 0;
		int maxPos = 0;
		for (int i = 0; i < nums.size() - 1; ++i) {
			maxPos = max(nums[i] + i, maxPos);
			if (i == end) {
				end = maxPos;
				++ans;
			}
		}
		return ans;
	}
};