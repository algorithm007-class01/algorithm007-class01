<?php

class Solution
{

    private $parent = [];
    private $rank = [];
    private $count = 0;

    function find(int $i)
    {
        if ($this->parent[$i] != $i) {
            $this->parent[$i] = $this->find($this->parent[$i]);
        }
        return $this->parent[$i];
    }

    function union($x, $y)
    {
        $rootX = $this->find($x);
        $rootY = $this->find($y);
        if ($rootX != $rootY) {
            if ($this->rank[$rootX] > $this->rank[$rootY]) {
                $this->parent[$rootY] = $rootX;
            } else if ($this->rank[$rootX] < $this->rank[$rootY]) {
                $this->parent[$rootX] = $rootY;
            } else {
                $this->parent[$rootY] = $rootX;
                $this->rank[$rootX] += 1;
            }
            --$this->count;
        }

    }

    /**
     * @param String[][] $grid
     * @return Integer
     */
    function findCircleNum($grid)
    {
        if (empty($grid) || !$grid[0]) return 0;
        $m = $this->count = count($grid);
        for ($i = 0; $i < $m; ++$i) {
            $this->parent[$i] = $i;
            $this->rank[$i] = 0;
        }
        for ($i = 0; $i < $m; ++$i) {
            for ($j = 0; $j < $m; ++$j) {
                if ($grid[$i][$j] == 1 && $i != $j) {
                    $this->union($i, $j);       
                }
                
            }
        }

        return $this->count;
    }
}

?>