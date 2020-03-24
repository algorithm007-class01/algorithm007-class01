#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> tmp;
        vector<int> res;

        for(int i = 0; i < nums.size(); ++i) {
            int elem = target - nums[i];
            if(tmp.find(elem) != tmp.end()) {
                res.push_back(tmp[elem]);
                res.push_back(i);
                return res;
            } else {
                tmp[nums[i]] = i;
            } 
        }

        return res;
    }
};

int main() {
    vector<int> arr = {2, 7, 11, 15};
    int target = 9;

    Solution s = Solution();
    vector<int> res = s.twoSum(arr, target);

    for(int i : res) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}