<?php
/**
 * 49. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    输出: 6
双指针法，左右夹逼处理
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function trap($height) {
        
        $left = 0; 
        $right = count( $height ) - 1;
        $left_max = $right_max = 0 ;
        $water = 0;

        while( $left < $right ) {
            if( $height[$left] <= $height[$right] ) {
                $height[$left] > $left_max ? ( $left_max = $height[$left] ) : $water += ($left_max - $height[$left]); 
                $left ++;
            }else{
                $height[$right] > $right_max ? ( $right_max = $height[$right] ) : $water += ($right_max-$height[$right]);
                $right -- ;
            }
        }
        return $water;
    }
}
$strs = [0,1,0,2,1,0,1,3,2,1,2,1];
$class  = new Solution;
$s = $class->trap( $strs );
var_dump($s);
?>