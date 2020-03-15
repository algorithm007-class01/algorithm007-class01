class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0){
            return;
        }
        int count = 0;
        for (int index = 0; count < nums.length; index++) {
            int current = index;
            int pre = nums[index];
            do {
                int targetIndex = (current + k) % nums.length;
                int temp = nums[targetIndex];
                nums[targetIndex] = pre;
                pre = temp;
                current = targetIndex;
                count++;
            }
            while (index != current);
        }
    }
}