<?php
/**
 *64. 最小路径和
https://leetcode-cn.com/problems/minimum-path-sum/
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {
        $m = count($grid);
        $n = count($grid[0]);
        if ($m <= 0 || $n <= 0) return 0;

        $dp = [];
        $dp[0][0] = $grid[0][0];

        for ($i = 1; $i < $m; $i++) {
            $dp[$i][0] = $dp[$i - 1][0] + $grid[$i][0];
        }

        for ($j = 0; $j < $n; $j++) {
            $dp[0][$j] = $dp[0][$j - 1] + $grid[0][$j];
        }

        for ($i = 1; $i < $m; $i++) {
            for ($j = 1; $j < $n; $j++) {
                $dp[$i][$j] = min($dp[$i - 1][$j], $dp[$i][$j - 1]) + $grid[$i][$j];
            }
        }

        return $dp[$m - 1][$n - 1];
    }
}