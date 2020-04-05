<?php
class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $tmps = [];
        $arrRes = [];
        foreach($strs as $k => $str) {
            $items = str_split($str);
            sort($items);
            $newStr = implode("", $items);
            $arrRes[$newStr][$k] = $str;
        }
        return $arrRes;
    }
}
