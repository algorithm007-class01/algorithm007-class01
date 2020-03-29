class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> mytable;
        for (int i = 0; i< nums.size();i++){
            mytable[nums[i]] = i;
        }
        for (int i = 0 ;i<nums.size();i++){
            if (mytable.find(target-nums[i])!=mytable.end() && mytable[target-nums[i]]!=i ){
                return {i,mytable[target-nums[i]]};
            }
        }
        return {};
    }
};