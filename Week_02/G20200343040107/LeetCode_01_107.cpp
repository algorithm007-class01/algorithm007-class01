#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std; 

class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		if (nums.size() < 2) {
			return vector<int>();
		}

		unordered_map<int, int> val_idx;
		int len = nums.size();
		for (int i = 0; i < len; i++) {
			val_idx[nums[i]] = i;
		}
		for (int i = 0; i < len; i++) {
			if (val_idx.find(target - nums[i]) != val_idx.end()
				&& val_idx[target - nums[i]] != i) {
				return { i, val_idx[target - nums[i]] };
			}
		}
		return {};
	}
};

static void print_res(const vector<int>& nums) {
    int len = nums.size(); 
    for(int i = 0;i < len; i++) {
        cout << nums[i];
        if(i != len-1) {
            cout << ", "; 
        } 
    }
    cout << endl; 
}

void test_case() {
    Solution solu; 
    vector<int> vec_empty;
    print_res(solu.twoSum(vec_empty, 4));

    vector<int> vec_has = {2, 7, 11, 15}; 
    print_res(solu.twoSum(vec_has, 9));

    print_res(solu.twoSum(vec_has, 12));
}

int main(int argc, char* argv) {
	test_case(); 
	return 0; 
}