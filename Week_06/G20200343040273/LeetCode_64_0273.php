<?php
/*
 *64 最小路径
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。
    示例:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7 。解释: 因为路径 1→3→1→1→1 的总和最小。
 * 动态规划。
 * dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + [i][j]
 */
class Solution {
    function minPathSum($grid) {
        $m = count( $grid );
        $n = count( $grid[0] );
        if( !$grid ) return 0;
        
        $dp[0][0] = $grid[0][0];
        //第一行
        for( $i = 1 ; $i < $n ; $i ++) {
            $dp[0][$i] = $dp[0][$i-1] + $grid[0][$i];
        }
        //第一列
        for( $j = 1 ; $j < $m ; $j++ ) {
            $dp[$j][0] = $dp[$j-1][0] + $grid[$j][0];
        }
        for( $i = 1 ; $i < $m ; $i++ ) {
            for( $j = 1 ; $j < $n ; $j++  ) {
                $dp[$i][$j] = min( $dp[$i-1][$j] , $dp[$i][$j-1] ) + $grid[$i][$j];
            }
        }
        return $dp[$m-1][$n-1];
    }   
}
?>