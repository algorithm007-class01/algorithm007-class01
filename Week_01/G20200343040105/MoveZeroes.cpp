//283.移动0   

//双指针替换法
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i = 0, j = 0;
        for (; i < nums.size(); ++i) {
            if (nums[i] != 0) {
                if (i != j) swap (nums[i], nums[++j]);
            }
            else ++j;
        }   
    }
};
//时间复杂度 O(n) 空间复杂度O(1)
