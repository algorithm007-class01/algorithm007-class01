#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 暴力求解法
class Solution1 {
public:
    int removeDuplicates(vector<int>& nums) {
        bool hasZero = false;
        for(int i = 0; i < nums.size() - 1; ++i)
            for(int j = i + 1; j < nums.size(); ++j) {
                if(nums[i] == 0 || nums[j] == 0)
                    hasZero = true;
                if(nums[i] == nums[j])
                    nums[j] = 0;
            }

        int index = 0;
        for(int i = 0; i < nums.size(); ++i) {
            if(nums[i] != 0)
                nums[index++] = nums[i];
        }

        int count = index;

        while (index < nums.size())        
            nums[index++] = 0;
        
        return hasZero ? (count + 1): count;
    }
};

// 双指针法
class Solution2 {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;

        sort(nums.begin(), nums.end());

        int i = 0;
        for(int j = 1; j < nums.size(); ++j) {
            if(nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
};

int main() {
    Solution2 s = Solution2();
    vector<int> n = {0,0,1,1,1,2,2,3,3,4};
    int count = s.removeDuplicates(n);
    cout << "count: " << count << endl;
    for(int i : n) {
        cout << i << ' ';  
    }
    cout << endl;

}