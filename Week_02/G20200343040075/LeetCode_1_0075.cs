public class Solution {
    /// <summary>用字典缓存元素及其下标，此为O(n)</summary>
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> dic = new Dictionary<int, int>();
        for(int i = 0; i < nums.Length; i++)
        {
            dic[nums[i]] = i;
        }
        for(int i = 0; i < nums.Length; i++)
        {
            int ot = target - nums[i];
            if (dic.ContainsKey(ot) && i != dic[ot])
            {
                return new int[]{i, dic[ot]};
            }
        }
        return new int[0];
    }
}