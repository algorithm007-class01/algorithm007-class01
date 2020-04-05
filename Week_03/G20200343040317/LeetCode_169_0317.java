class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int left, int right) {
        // 终结条件，到达单个元素的情况
        if (left == right) {
            return nums[left];
        }
        // 分治 一分为二的开始找
        int mid = (left + right) / 2;
        int leftMaxCountNumber = majorityElementRec(nums, left, mid);
        int rightMaxCountNumber = majorityElementRec(nums, mid + 1, right);
        if (leftMaxCountNumber == rightMaxCountNumber) {
            return leftMaxCountNumber;
        }
        int leftCount = count(nums, leftMaxCountNumber, left, mid);
        int rightCount = count(nums, rightMaxCountNumber, mid + 1, right);
        return leftCount > rightCount ? leftMaxCountNumber : rightMaxCountNumber;
    }

    private int count(int[] nums, int target, int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            if (nums[i] == target) {
                sum++;
            }
        }
        return sum;
    }
}