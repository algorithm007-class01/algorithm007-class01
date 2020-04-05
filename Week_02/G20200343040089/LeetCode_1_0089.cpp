/*
* Summary:tow-sum Solution
* Parameters:
*   nums: source array
*   target: target value
* Return: match index vector
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash_mp;
        for (size_t i = 0; i < nums.size(); ++i) {
            if (hash_mp.find(target - nums[i]) != hash_mp.end()) {
                return {i, hash_mp[target - nums[i]]};
            }
            hash_mp[nums[i]] = i;
        }
        return {};
    }
};