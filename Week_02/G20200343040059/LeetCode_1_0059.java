/**
*  两数之和
*  使用Hash表解决思路
*  遍历数组nums,如果Hash表中有nums[i]对应的target元素,则返回;
*  否则,将值和index存入Hash表,继续下一个遍历
*
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 定义Hash表
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {

            // 判断是否包含特定值
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                // 将没匹配上的数据存入Hash表等待下一次匹配
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}