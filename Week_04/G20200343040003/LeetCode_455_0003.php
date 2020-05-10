<?php

class Solution {
    
    /**
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    function findContentChildren($g, $s) {
        sort($g);
        sort($s);
        $currentJ = 0;
        $num = 0;
        for ($i = 0; $i < count($g); $i++) {
            if ($currentJ >= count($s)) {
                break;
            }
            for ($j = $currentJ; $j < count($s); $j++) {
                $currentJ = $j + 1;
                if ($s[$j] >= $g[$i]) {
                    $num++;
                    break;
                }
            }
        }
        return $num;
    }
}