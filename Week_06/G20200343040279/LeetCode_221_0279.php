<?php

/**
 *221. 最大正方形
https://leetcode-cn.com/problems/maximal-square/
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4


 */
class Solution {

    /**
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare($matrix) {
        if (empty($matrix)) return 0;

        $dp = [];
        $row = count($matrix);
        $col = count($matrix[0]);
        $max = 0;
        for ($i = 1; $i <= $row; $i++) {
            for ($j = 1; $j <= $col; $j++) {
                // 初始化，注意不是$dp[$i][$j] = $matrix[$i][$j]
                if ($i == 1 || $j == 1) $dp[$i][$j] = $matrix[$i - 1][$j - 1];

                if ($matrix[$i - 1][$j - 1] == '1') {
                    $dp[$i][$j] = min($dp[$i - 1][$j], $dp[$i][$j - 1], $dp[$i - 1][$j - 1]) + 1;
                    $max = max($max, $dp[$i][$j]);
                }
            }
        }

        return $max * $max;
    }
}