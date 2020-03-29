<?php

######### 接雨水 ###########

$str = [0,1,0,2,1,0,1,3,2,1,2,1];

function trap($height) {

    $sum = 0;
    $stack = [];
    $current = 0;
    $count = count($height);
    while ($current < $count){

        //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
        while(!empty($stack) && $height[$current] > $height[end($stack)]){

            // 取出要出栈的元素
            $stackNumber = $height[end($stack)];

            // 出栈
            array_pop($stack);

            // 中止循环
            if(empty($stack)){
                break;
            }

            // 计算面积
            $distance = $current - end($stack) -1;
            $min = min($height[end($stack)], $height[$current]);
            $sum = $sum + $distance * ($min - $stackNumber);
        }

        array_push($stack, $current);
        $current++;
    }

    return $sum;

}

var_dump(trap($str));