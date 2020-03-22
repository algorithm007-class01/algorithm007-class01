class Solution {
    public void rotate(int[] nums, int k) {
        int lastNum = nums[0];
        int index = 0;

        for (int i = 0, count = 0; count < nums.length; count++) {
            index = (index + k) % nums.length;

            // 完成一个步长序列循环
            if (index == i) {
                // 起始位置设置
                nums[index] = lastNum;
                i++;

                // 重新初始化, 最后一遍遍历时, 不需要重新初始化
                if (count < nums.length - 1) {
                    lastNum = nums[i];
                    index = i;
                }
            }
            int temp = nums[index];
            nums[index] = lastNum;
            lastNum = temp;
        }
    }
}