<?php

class Solution {
    
    /**
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare($matrix) {
        $rows = count($matrix);
        $cols = $rows > 0 ? count($matrix[0]) : 0;
        $dp = [];
        $maxsqlen = $prev = 0;
        for ($i = 1; $i <= $rows; $i++) {
            for ($j = 1; $j <= $cols; $j++) {
                $temp = $dp[$j];
                if ($matrix[$i - 1][$j - 1] == '1') {
                    $dp[$j] = min(min($dp[$j - 1], $prev), $dp[$j]) + 1;
                    $maxsqlen = max($maxsqlen, $dp[$j]);
                } else {
                    $dp[$j] = 0;
                }
                $prev = $temp;
            }
        }
        return $maxsqlen * $maxsqlen;
    }
}