<?php

class Solution {
    
    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        $i = 0;
        for ($j = 1; $j < count($nums); $j++) {
            if($nums[$i] != $nums[$j]) {
                $nums[++$i] = $nums[$j];
            }
        }
        return $i + 1;
    }
}