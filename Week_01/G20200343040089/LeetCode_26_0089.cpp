class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int length = nums.size();
        if (length == 0)
            return 0;
        int p = 0;          //指向前面元素的位置
        int q = 1;          //指向后面元素的位置，每次找到第一个与p指向的元素不相等的元素
        while (q < length) {
            if (nums[p] != nums[q]) {
                    p++;                  
                    nums[p] = nums[q];
            }
            q++;
        }
        return p + 1;
    }
};