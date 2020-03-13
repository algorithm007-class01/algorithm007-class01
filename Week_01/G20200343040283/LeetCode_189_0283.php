<?php

$nums = [1,2,3,4,5,6,7];

function rotate($nums, $k)
{
    $result = [];
    $count = count($nums);
    for ($i = 0; $i < $count; $i++) {
        if ($k >= $count) {
            $k = $k % $count;
        }
        if (($i + $k) > ($count - 1)) {
            $index = ($i + $k) - ($count - 1) - 1;
        } else {
            $index = $i + $k;
        }
        $result[$index] = $nums[$i];
    }
    ksort($result);
    $nums = $result;
    return $nums;
}

echo "<pre>";
print_r(rotate($nums, 3));

