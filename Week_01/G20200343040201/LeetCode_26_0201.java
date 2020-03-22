public class LeetCode_26_0201 {
    public int removeDuplicates(int[] nums) {
        if (nums == null|| nums.length == 0) return 0;
        int j = 0;  //不重复元素的下标
        // 快指针i，遍历整个数组，寻找不重复元素
        for (int i = 0; i < nums.length - 1; i++) {
            // i与i+1 元素不相等，证明i的元素应该被填入到j位置
            if (nums[i] != nums[i + 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        // 因为i没有到最后一个位置，因为要顾及到i+1不越界
        // 但数组最后一个元素一定是一定要填入到位置j的
        nums[j] = nums[nums.length - 1];

        //因为j是不重复数组的最后一个元素的下标，所有，数组长度要+1
        return j + 1;
    }
}
