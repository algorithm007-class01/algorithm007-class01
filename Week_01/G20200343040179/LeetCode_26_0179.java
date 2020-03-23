package Week_01.G20200343040179;

class LeetCode_26_0179 {
    /**
     * 双指针
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                continue;
            }
            j++;
            nums[j] = nums[i];
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 4, 5 };
        int i = new LeetCode_26_0179().removeDuplicates(nums);
        System.out.println(i);
    }

}