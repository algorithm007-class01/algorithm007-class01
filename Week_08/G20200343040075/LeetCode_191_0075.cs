/*
 * @lc app=leetcode.cn id=191 lang=csharp
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    public int HammingWeight2 (uint n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }

    public int HammingWeight (uint n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n &= (n - 1);//清掉最低位的1
        }
        return cnt;
    }
}
// @lc code=end