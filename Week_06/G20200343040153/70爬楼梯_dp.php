<?php

class solution_70 {

    public function execute($num)
    {
        $dp[1] = 1;
        $dp[2] = 2;
        for ($i = 3; $i <= $num; $i++) {
            $dp[$i] = $dp[$i - 1] + $dp[$i - 2];
        }
        return $dp[$num];
    }
}

$num = (new solution_70())->execute(5);
echo $num;
