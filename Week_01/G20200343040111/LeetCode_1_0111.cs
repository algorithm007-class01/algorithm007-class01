public class Solution 
{
    public int[] TwoSum(int[] nums, int target)
    {
        var result = new int[2];
        for (var i = 0; i < nums.Length; i++)
        {
            for (var j = i+1; j < nums.Length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new Exception("Not found.");
    }
}