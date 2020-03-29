
public class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        for (var i = 0; i < nums.Length; i++)
        {
            var complement = target - nums[i];
            if (dict.ContainsKey(complement))
            {
                return new int[] { dict.GetValueOrDefault(complement), i };
            }
            dict.TryAdd(nums[i], i);
        }
        throw new Exception("No two sum solution");
    }
}