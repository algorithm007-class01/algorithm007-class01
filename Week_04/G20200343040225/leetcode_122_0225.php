<?php

class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        if (empty($prices)) return 0;

        $dp = [];

        $dp[0][0] = 0;
        $dp[0][1] = -$prices[0];
        for ($i = 1; $i < count($prices); $i++) {
            $dp[$i][0] = max($dp[$i - 1][0], $dp[$i - 1][1] + $prices[$i]);
            $dp[$i][1] = max($dp[$i - 1][0] - $prices[$i], $dp[$i - 1][1]);
        }

        return $dp[count($prices) - 1][0];
    }
}
