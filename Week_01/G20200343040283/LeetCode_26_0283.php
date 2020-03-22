<?php

$nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];

function removeDuplicates(&$nums)
{
    $count = count($nums);
    if ($count <= 1) {
        return $count;
    }
    $firstNum = $nums[0];
    $length = 1;
    for ($i = 1; $i < $count; $i++) {
        if ($nums[$i] == $firstNum) {
            unset($nums[$i]);
        } else {
            $firstNum = $nums[$i];
            $length++;
        }
    }

    // return $length;
    // 返回是数组
    return $nums;
}

echo "<pre>";
print_r(removeDuplicates($nums));
