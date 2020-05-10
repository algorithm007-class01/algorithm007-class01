<?php

//使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

class Solution
{
    public function findKey($arr)
    {
        $key = $this->erfen($arr, 0, count($arr) - 1);
        return $key;
    }
    
    public function binarySearch($arr, $left, $right)
    {
        if ($left >= $right) {
            return false;
        }
        $middle = floor(($left + $right) / 2);
        if ($arr[$middle] < $arr[$middle - 1]) {
            return $middle;
        } else {
            if ($arr[$middle] > $arr[$right]) {
                return $this->binarySearch($arr, $middle, $right);
            } else {
                return $this->binarySearch($arr, $left, $middle);
            }
        }
    }
}