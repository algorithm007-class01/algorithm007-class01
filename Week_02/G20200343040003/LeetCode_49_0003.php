<?php

class Solution {
    
    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $sortArr = [];
        for ($i = 0; $i < count($strs); $i++) {
            $str = $this->sortStr($strs[$i]);
            $sortArr[$str][] = $strs[$i];
        }
        return $sortArr;
    }
    
    /**
     * 排序字符串
     * @param $str
     * @return string
     */
    function sortStr($str) {
        $arr = str_split($str);
        sort($arr);
        return implode('', $arr);
    }
}