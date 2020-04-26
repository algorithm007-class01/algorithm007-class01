<?php

class solution_120 {

    public function execute($triangle)
    {
        $len = count($triangle) - 2;
        for ($i = $len; $i > -1; $i--) {
            $row_len = count($triangle[$i]);
            for ($j = 0; $j < $row_len; $j++) {
                $triangle[$i][$j] = $triangle[$i][$j] + min($triangle[$i + 1][$j], $triangle[$i + 1][$j + 1]);
            }
        }
        return $triangle[0][0];
    }
    
}

$triangle = [
    [2],
    [3,4],
    [6,5,7],
    [4,1,8,3]
];

$min = (new solution_120())->execute($triangle);
echo $min;


