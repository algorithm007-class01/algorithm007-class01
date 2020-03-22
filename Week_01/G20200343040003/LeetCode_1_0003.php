<?php

class Solution {
    
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum1($nums, $target) {
        for ($i = 0; $i < count($nums) - 1; $i++) {
            for ($j = $i + 1; $j < count($nums); $j++) {
                if($nums[$i] + $nums[$j] == $target) {
                    return [$i, $j];
                }
            }
        }
    }
    
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum2($nums, $target) {
        $found = [];
        for ($i = 0; $i < count($nums); $i++) {
            $num = $target - $nums[$i];
            if(array_key_exists($num, $found)) {
                return [$found[$num], $i];
            }
            $found[$nums[$i]] = $i;
        }
    }
}