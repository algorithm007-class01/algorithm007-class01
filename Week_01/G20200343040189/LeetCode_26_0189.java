class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < len) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p+1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return (p + 1);
    }
}