<?php
/**
 * 面试题49：丑数
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */

//49丑数
class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function nthUglyNumber($n) {

        $p2 = $p3 = $p5 = 0;
        $dp[0] = 1;
        for( $i = 1 ; $i < $n ; $i++ ) {
            $dp[$i] = min( $dp[$p2]*2 , min( $dp[$p3]*3 , $dp[$p5]*5 ) );
            if( $dp[$i] == $dp[$p2] *2 ) $p2 ++;
            if( $dp[$i] == $dp[$p3] *3 ) $p3 ++;
            if( $dp[$i] == $dp[$p5] *5 ) $p5 ++;
        }
        return $dp[$n-1];
    }
}
?>