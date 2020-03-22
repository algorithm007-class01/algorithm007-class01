<?php

class Solution {
    
    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        $count = count($nums);
        $newArr = [];
        for ($i = 0; $i < $count; $i++) {
            $newArr[($i + $k) % $count] = $nums[$i];
        }
        $nums = $newArr;
        ksort($nums);
    }
}