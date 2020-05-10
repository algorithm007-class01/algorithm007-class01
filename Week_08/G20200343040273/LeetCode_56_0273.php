<?php

/**
 * 56 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
*示例 1:

*输入: [[1,3],[2,6],[8,10],[15,18]]
*输出: [[1,6],[8,10],[15,18]]
*解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * */ 
class Solution {

    /**
     * @param Integer[][] $intervals
     * @return Integer[][]
     */
    function merge($intervals) {
        if( count( $intervals ) < 1 )  return [];
        sort($intervals);
        $j = 0;
        $ans[$j] = $intervals[0];
        for( $i=1 ; $i < count($intervals); $i++ ) {
            $start = $intervals[$i][0];
            $end = $intervals[$i][1];
            if( $start <= $ans[$j][1] ) {
                $ans[$j] = [ $ans[$j][0] , max( $ans[$j][1] ,$end ) ];
            }else{
                $j++;
                $ans[$j] = $intervals[$i];
            }
        }
        return $ans;
    }
}

?>