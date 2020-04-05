//方法1：暴力求解                                                      cpp
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        for (int i = 0; i < nums.size() - 1; ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                if (nums[i] + nums[j] == target) {
                    return {i, j};
                }
            }
        }
        return {};
    }
};
//时间复杂度：O(n^2)  空间复杂度：O(1)


//方法2：一遍哈希表 （空间换时间）
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> res;
        for (int i = 0; i < nums.size(); ++i) {
            if (res.count(target - nums[i])) {
                return {res[target - nums[i]], i};
            }
            res[nums[i]] = i;  //update
        }
        return {};
    }
};
//时间复杂度：O(n) 空间复杂度：O(n)