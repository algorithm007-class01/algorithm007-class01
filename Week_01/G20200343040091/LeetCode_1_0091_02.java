  class Solution {

    public int[] twoSum(int[] nums, int target) {

      /**
       * 两遍哈希表，参考中文官方题解
       *
       * 时间复杂度：O(n)，我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)
       * 空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
       */

      Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

      for (int i = 0; i < nums.length; i++) {
        tempMap.put(nums[i], i);
      }

      for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (tempMap.containsKey(complement) && tempMap.get(complement) != i) {
          return new int[]{i, tempMap.get(complement)};
        }
      }

      return new int[0];

    }
  }