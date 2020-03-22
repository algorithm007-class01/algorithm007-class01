<?php


##### 字母异位词分组 #######

function groupAnagrams($strs) {
    $result = [];
    for($i = 0; $i<count($strs); $i++){
        $arr = str_split($strs[$i]);
        sort($arr);
        $tmp_str = implode("", $arr);
        $result[$tmp_str][] = $strs[$i];
    }

    return array_values($result);
}

$nums = ["eat", "tea", "tan", "ate", "nat", "bat"];

var_dump(groupAnagrams($nums));