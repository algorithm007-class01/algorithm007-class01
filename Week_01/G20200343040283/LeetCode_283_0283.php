<?php
$arr = [0, 1, 0, 3, 12];

$num = 0;
for ($i = 0; $i < count($arr); $i++) {
    if ($arr[$i] != 0) {
        $arr[$num] = $arr[$i];
        if($i != $num){
            $arr[$i] = 0;
        }
        $num++;
    }
}
return $arr;