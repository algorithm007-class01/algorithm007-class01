<?php

class solution_63 {

    public function uniquePathsWithObstacles($obstacleGrid)
    {
        if ($obstacleGrid[0][0] == 1) {
            return 0;
        }

        $column = count($obstacleGrid[0]);
        $row    = count($obstacleGrid);
        for ($i = 0; $i < $row; $i++) {
            for ($j = 0; $j < $column; $j++) {
                if ($obstacleGrid[$i][$j] == 1) {
                    $obstacleGrid[$i][$j] = 0;
                } else if ($i == 0 && $j == 0) {
                    $obstacleGrid[$i][$j] = 1;
                } else {
                    $top    = $i - 1 < 0 ? 0 : $obstacleGrid[$i - 1][$j];
                    $left   = $j - 1 < 0 ? 0 : $obstacleGrid[$i][$j - 1];
                    $obstacleGrid[$i][$j] = $top + $left;
                }
            }
        }

        return $obstacleGrid[$i - 1][$j - 1];
    }

}

$data = [[0,0,0],[0,1,0],[0,0,0]];

$num = (new solution_63())->uniquePathsWithObstacles($data);
echo $num;


