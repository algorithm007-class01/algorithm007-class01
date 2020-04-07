public class Solution
{
    public bool LemonadeChange(int[] bills)
    {
        int[] cash = new int[bills.Max(x => x) + 1];
        int change = 0;
        foreach (int bill in bills)
        {
            cash[bill]++;
            change = bill - 5;

            if (change > 0)
            {
                if (change == 5)
                {
                    if (cash[5] > 0)
                    {
                        --cash[5];
                    }
                    else return false;
                }
                else if (change == 10)
                {
                    if (cash[5] > 1)
                    {
                        cash[5] -= 2;
                    }
                    else if (cash[10] > 0)
                    {
                        --cash[10];
                    }
                    else return false;
                }
                else if (change == 15)
                {
                    if ((cash[10] > 0) &&
                        (cash[5] > 0))
                    {
                        --cash[10];
                        --cash[5];
                    }
                    else if (cash[5] > 2)
                    {
                        cash[5] -= 3;
                    }
                    else return false;
                }
            }
        }
        return true;
    }
}