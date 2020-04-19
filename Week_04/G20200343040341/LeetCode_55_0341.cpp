class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size() <= 0) return false;

        int temp = nums.size() - 1;
        for(int i=nums.size()-1; i>=0; i--){
            if(nums[i] + i >= temp) temp = i;
        }
        return temp == 0;
    }
};