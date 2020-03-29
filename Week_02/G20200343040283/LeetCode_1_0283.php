<?php

#### 两数之和  #####

$nums = [2, 7, 11, 15];
$target = 9;

// 哈希解法
function twoSum($nums, $target) {
    $count = count($nums);
    $result = [];
    for($i = 0; $i < $count; $i++){
        $diff = $target - $nums[$i];
        if(!isset($result[$nums[$i]])){
            $result[$diff] = $i;
        }else{
            return [$result[$nums[$i]], $i];
        }
    }
}

var_dump(twoSum($nums, $target));