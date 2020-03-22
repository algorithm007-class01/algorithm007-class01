public class Solution
{
    public void MoveZeroes(int[] nums)
    {
        var zeroIndex = 0;
        for (var i = 0; i < nums.Length; i++)
        {
            if (nums[i] != 0 && i != zeroIndex && nums[zeroIndex] == 0)
            {
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                zeroIndex++;
            }

            if (nums[zeroIndex] != 0)
            {
                zeroIndex++;
            }
        }
    }
}