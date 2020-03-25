class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
	// hash中记录数值对应的索引
	unordered_map<int,int> temp;
	for(int i = 0; i < nums.size(); i++){
		unordered_map<int,int>::iterator it = temp.find(target - nums[i]);
		if(it != temp.end()){
			
			return {i, it->second};
		}
		hash[nums[i]] = i;
	}
	return {};
    }
};
