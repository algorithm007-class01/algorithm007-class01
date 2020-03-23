package Week_01.G20200343040179;

class LeetCode_189_0179 {

    /**
     * 暴力求解 { 1, 2, 3, 4, 5 };
     * <P/>
     * 第一次5和1交换,1和2交换,2和3交换 ....
     * <P/>
     * 第一次：【5,1,2,3,4】
     * <P/>
     * 第二次：【4,5,1,2,3】
     * <P/>
     * 第三次：【3,4,5,1,2】
     * 
     */
    public void rotate1(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) {
            int previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 以k为分界点进行反转，时间复杂度为O(n),空间复杂度为O(1)
     * <P/>
     * 反转三次
     * <P/>
     * 第一次：整体反转
     * <P/>
     * 第二次：反转K之前的数据
     * <P/>
     * 第二次：反转K之后的数据
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 使用环装替换，时间复杂度为O(n),空间复杂度为O(1) count：每个数都需要换位置，所以count需要小于nums.length
     */
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int pre = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        LeetCode_189_0179 test = new LeetCode_189_0179();
        test.rotate(nums, k);

    }

}