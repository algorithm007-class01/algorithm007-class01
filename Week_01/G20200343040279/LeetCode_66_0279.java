public class Solution {
	public static  int[] plusOne(int[] nums) {
		int len = nums.length;
		for (int i = len - 1; i >= 0; i--) {
			nums[i]++;
			nums[i] %= 10;
			if (nums[i] != 0) {
				return nums;
			}
		}
		nums = new int[len + 1];
		nums[0] = 1;
		return nums;
	}
}