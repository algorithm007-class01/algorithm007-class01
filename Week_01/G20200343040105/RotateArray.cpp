//189. 旋转数组

//切片转置
class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (k > nums.size()) k = k % nums.size();   //对 K 取模
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nuns.begin() + k);
        reverse(num.begin() + k, nums.end());    
    }
};
//时间复杂度 O(n) 空间复杂度O(n)