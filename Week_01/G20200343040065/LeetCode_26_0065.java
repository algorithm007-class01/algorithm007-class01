package leetCode;

public class LeetCode26_0065 {
	
	public int removeDuplicates(int[] nums) {
		
		int j = 0;
		for (int i = 0;i < nums.length;i++) {
			if (nums[i] != nums[j]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j + 1;
    }
}
