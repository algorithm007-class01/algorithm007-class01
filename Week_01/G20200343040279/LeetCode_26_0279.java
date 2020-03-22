
public class Solution {
	public static void main(int[] args) {

	}

	public static int removeReplicates(int[] nums) {
		if (nums.lenght == 0) return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}