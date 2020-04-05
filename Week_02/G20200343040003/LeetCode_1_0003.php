<?php

class Solution {
    
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $search[$nums[0]] = 0;
        for ($i = 1; $i < count($nums); $i++) {
            $searchVal = $target - $nums[$i];
            if (isset($search[$searchVal])) {
                return [$search[$searchVal], $i];
            }
            isset($search[$nums[$i]]) || $search[$nums[$i]] = $i;
        }
        return [];
    }
}