class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0){
            return 0;
        }
        int k = 0;
        for (int i = 0;i<nums.size()-1;){
            if (nums[i] == nums [i+1] && i<nums.size()-1){
                i++;
            }
            else{
                nums[++k]=nums[++i];
            }
        }
        return k+1;
    }
};