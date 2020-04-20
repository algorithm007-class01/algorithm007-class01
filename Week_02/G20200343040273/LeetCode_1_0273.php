<?php
/**
 * 两数之和，哈希表
 */
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {

        $map = array();
        for( $i = 0 ; $i < count( $nums ) ; $i ++ ) {
            $search = $target - $nums[$i];
            if( isset( $map[$search] ) ) {
                return [$map[$search],$i];
            }else{
                $map[$nums[$i]] = $i;
            }
        }
    }
}
$nums = [2,7,11,15];
$target = 9;
$class  = new Solution;
$s = $class->twoSum( $nums , $target );
var_dump($s);
?>