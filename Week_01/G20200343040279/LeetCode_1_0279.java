public class Solution {

	/**
	 * 暴力解法
	 * @param  nums   [description]
	 * @param  target [description]
	 * @return        [description]
	 */
	public static int[] plusTwo(int[] nums, int target) {
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length - 1; j++) {
				if (nums[i] + nums[j] == target) {
					ret[0] = i;
					ret[1] = j;
					return ret;
				}
			}
		}
	}

	public static int[] plusTwoHashMap(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}
}