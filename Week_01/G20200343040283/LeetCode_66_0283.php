<?php

$digits = [1, 2, 3];
$count = count($digits);
$digits[$count-1] = $digits[$count-1] +1;

for ($i = $count - 1; $i > 0; $i--) {
    if ($digits[$i] >=10) {
        $digits[$i] = 0;
        $digits[$i - 1] = $digits[$i - 1] + 1;
    }
}

if($digits[0] >= 10){
    $digits[0] =0;
    array_unshift($digits,1);
}

return $digits;