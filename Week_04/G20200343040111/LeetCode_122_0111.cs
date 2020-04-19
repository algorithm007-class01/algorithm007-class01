public class Solution
{
    public int MaxProfit(int[] prices)
    {
        var result = new int[2]
        {
            0,
            Int32.MinValue
        };
        foreach (int price in prices)
        {
            result = new int[2]
            {
                Math.Max(result[0], result[1] + price),
                Math.Max(result[1], result[0] - price)
            };
        }
        return result[0];
    }
}