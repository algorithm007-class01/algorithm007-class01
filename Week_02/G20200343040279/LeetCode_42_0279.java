public class Solution {
	/**
	 * 接雨水 (双指针法)
	 * @param  nums [description]
	 * @return      [description]
	 */
	public static int trapTwoPoint(int[] nums) {
		int size = nums.length;
		int max_left = 0;
		int max_right = 0;
		int sum = 0;
		int left = 1;
		int right = size - 2;
		for (int i = 1; i < size - 1; i++) {
			if (nums[left - 1] < nums[right + 1]) {
				max_left = Math.max(max_left, nums[left - 1]);
				int min = max_left;
				if (min > nums[left]) {
					sum = sum + (min - mums[left]);
				}
				left++;
			} else {
				max_right = Math.max(max_right, nums[right + 1]);
				int min = max_right;
				if (min > nums[right]) {
					sum = sum + (min - nums[right]);
				}
				right--;
			}
		}
		return sum;
	}

	public static int trapDP(int[] nums) {
		int size = nums.length;
		int[] max_left = new int[size];
		int[] max_right = new int[size];
		int sum = 0;
		for (int i = 1; i < size - 1; i++) {
			max_left[i] = Math.max(max_left[i - 1], nums[i - 1]);
		}

		for (int i = size - 2; i >= 0; i--) {
			max_right[i] = Math.max(max_right[i + 1], nums[i + 1]);
		}

		for (int i = 1; i < size - 1; i++) {
			int min = Math.min(max_left[i], max_right[i]);
			if (min > nums[i]) {
				sum = sum + (min - nums[i]);
			}
		}
		return sum;
	}
}