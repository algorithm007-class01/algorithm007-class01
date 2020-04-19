/*
 * @lc app=leetcode.cn id=860 lang=csharp
 *
 * [860] 柠檬水找零
 */

// @lc code=start
public class Solution {
    /// <summary>
    /// 用两个数记录可用零钱
    /// </summary>
    /// <param name="bills"></param>
    /// <returns></returns>
    public bool LemonadeChange (int[] bills) {
        if (bills.Length == 0) return true;
        if (bills[0] != 5) return false;

        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.Length; i++) {
            switch (bills[i]) {
                case 5:
                    five++;
                    break;
                case 10:
                    ten++;
                    five--;
                    if (five < 0) return false;
                    break;
                case 20:
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                    if (five < 0) return false;
                    break;
            }
        }
        return true;
    }
}
// @lc code=end