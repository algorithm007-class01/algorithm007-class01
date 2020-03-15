package leetCode;

public class LeetCode189_0065 {
	
	
	/**
	 * 两层循环
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		for (int i = 0;i < k;i++) {
			int last = nums[nums.length -1];
			int num = nums[0];
			for (int j = 1;j < nums.length;j++) {
				int numJ = nums[j];
				nums[j] = num;
				num = numJ;
			}
			nums[0] = last;
		}
    }
	
	/**
	 * 使用额外的数组
	 * @param nums
	 * @param k
	 */
	public void rotate1(int[] nums, int k) {
		int[] kNums = new int[k];
		if (k > nums.length)
			k %= nums.length;
		
		for (int i = 0;i < k;i++) {
			kNums[i] = nums[nums.length - k + i];
		}
		
		for (int i = nums.length - k - 1;i >= 0;i--) {
			nums[i + k] = nums[i];
		}
		for(int i = 0;i < k;i++) {
			nums[i] = kNums[i];
		}
	}
}
