<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $seek = [];
        $count = count($nums);
        for ($i = 0; $i < $count; $i++) {
            if ($data = array_keys($seek, ($target - $nums[$i]))) {
                return [$data[0], $i];
            }
            $seek[$i] = $nums[$i];
        }
    }
}
