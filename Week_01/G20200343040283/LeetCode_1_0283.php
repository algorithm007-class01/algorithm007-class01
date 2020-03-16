<?php

$nums = [2, 7, 11, 15];
$target = 9;

function str($nums, $target)
{
    $result = [];
    for ($i = 0; $i < count($nums); $i++) {
        $diff = $target - $nums[$i];
        if (!isset($result[$diff])){
            $result[$nums[$i]] = $i;
            continue;
        }
        return [$result[$diff],$i];
    }
}
echo "<pre>";
print_r(str($nums,$target));