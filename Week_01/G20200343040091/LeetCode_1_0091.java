class Solution {

    public int[] twoSum(int[] nums, int target) {

      /**
       * 一遍哈希表，参考中文官方题解
       *
       * 时间复杂度：O(n)，我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间
       * 空间复杂度：O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
       */

      Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

      for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (tempMap.containsKey(complement)) {
          return new int[]{tempMap.get(complement), i};
        }
        tempMap.put(nums[i], i);
      }

      return new int[0];

    }
  }
