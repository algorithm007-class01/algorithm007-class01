public class LeetCode_45_0147 {

    public int jump(int[] nums) {

        int maxPos = 0;
        int count = 0;
        int endPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == endPos) {
                endPos = maxPos;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(new LeetCode_45_0147().jump(nums));
    }
}
