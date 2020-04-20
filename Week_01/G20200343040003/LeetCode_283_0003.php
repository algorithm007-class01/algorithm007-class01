<?php

class Solution {
    
    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $len = count($nums);
        $count = 0;
        foreach($nums as $key => $num) {
            if($num == 0){
                $count ++;
                unset($nums[$key]);
            }
        }
        $nums += array_fill($len, $count, 0);
    }
}