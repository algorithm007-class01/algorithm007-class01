<?php

class Solution {
    
    private $result = [];
    
    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute($nums) {
        $this->perm($nums, 0, count($nums) - 1);
        return $this->result;
    }
    
    function perm($arr, $p, $q) {
        if($p == $q){
            $this->result[] = $arr;
            return;
        }
        for($i = $p; $i <= $q; $i++){
            $this->swap($arr, $p, $i);
            $this->perm($arr, $p+1, $q);
            $this->swap($arr, $p, $i);
        }
    }
    
    function swap(&$arr, $p, $q) {
        $tmp = $arr[$p];
        $arr[$p] = $arr[$q];
        $arr[$q] = $tmp;
    }
}