/*
### 解题思路
- `dp[i]`：到距离为i的点的最少操作次数（前提条件：运动方向要指向i点，初始速度大小要为1）
- 经过 m 次连续 A 操作之后的走过的距离：`len = 2^m - 1`
- 由于dp的条件为：速度为1，面朝目标点，所以只有进行R操作后，且运动方向朝向目标点才可以使用dp[]
- 因此计算`dp[i]`的思路就是 通过k次操作到达接近 i 点的 K 点，且此时的运动方向朝向i，遍历每一种k然后计算 `min(k + dp[abs(i - K)])`。
- 这个K点有三种可能，1：K < i；2：K = i；3：K > i；
    1. **K < i**: 首先通过 m 次A操作到达`j = (1 << m) - 1`; 然后执行一次R操作，此时方向与i点相反，于是进行q次A操作，移动了 `p = (1 << q) - 1`步，到达 j - p 点，此时只需要先翻转一次，然后执行`dp[i - (j - p)]`次操作即可。 这种情况下的条件为： `j < i`，`p < j`。
    2. **K = i**：通过m次A操作到达`j = (1 << m) - 1`，此时j = i，因此`dp[i] = m`。
    3. **K > i**：首先通过m次A操作到达`j = (1 << m) - 1`，然后执行一次R操作，此时就可以通过`dp[j - i]`获得`j - i`步的最少操作数，因为翻转一次之后速度为1，且方向也指向i的方向。
- 最终`dp[i]`就是在以上三种情况下找到一个最小值。
*/
class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; ++i) {
            dp[i] = Integer.MAX_VALUE;
            int m = 0, j = 0;
            for (; j < i; j = (1 << ++m) - 1) {
                for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1)
                    dp[i] = Math.min(dp[i], m + 1 + q + 1 + dp[i - (j - p)]);
            }
            // j > i 或 j = i时跳出循环。
            dp[i] = Math.min(dp[i], m + (j == i ? 0 : 1 + dp[j - i]));
        }
        return dp[target];
    }
}