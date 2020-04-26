<?php

class solution_53 {
    
    
    // 暴力法
    public function execute($nums)
    {
        $max_num    = PHP_INT_MIN;
        $len        = count($nums);
        for ($i = 0; $i < $len; $i++) {
            $sum = 0;
            for ($j = $i; $j < $len; $j++) {
                $sum += $nums[$j];
                if ($sum > $max_num) {
                    $max_num = $sum;
                }
            }
        }
        return $max_num;
    }

    // 动态规划
    public function execute_dp($nums)
    {
        $max_num    = PHP_INT_MIN;
        $len        = count($nums);
        $dp[0]      = $nums[0];
        for ($i = 1; $i < $len; $i++) {
            $dp[$i]     = max($dp[$i - 1] + $nums[$i], $nums[$i]);
            $max_num    = max($dp[$i], $max_num);
        }
        return $max_num;
    }

    // 贪心
    public function execute_gy($nums)
    {
        $max_num    = PHP_INT_MIN;
        $len        = count($nums);
        $sum        = 0;
        for ($i = 0; $i < $len; $i++) {
            $sum += $nums[$i];
            $max_num = max($sum, $max_num);
            if ($sum < 0) {
                $sum = 0;
            }
        }
        return $max_num;
    }
    
    //分治
    public function execute_divide($nums)
    {
        $len = (count($nums) - 1);
        return $this->helper($nums, 0, $len);
    }

    protected function helper($nums, $left, $right)
    {
        if ($left == $right) {
            return $nums[$left];
        }

        $p = floor(($left + $right) / 2);

        $left_sum   = $this->helper($nums, $left, $p);
        $right_sum  = $this->helper($nums, $p + 1, $right);
        $cross_sum  = $this->corss_sum($nums, $left, $right, $p);

        return max(max($left_sum, $right_sum), $cross_sum);
    }

    protected function corss_sum($nums, $left, $right, $p)
    {
        if ($left == $right) return $nums[$left];

        $left_subsum    = PHP_INT_MIN;
        $curr_sum       = 0;
        for ($i = $p; $i > $left - 1; $i--) {
            $curr_sum += $nums[$i];
            $left_subsum = max($left_subsum, $curr_sum);
        }

        $right_subsum   = PHP_INT_MIN;
        $curr_sum       = 0;
        for ($i = $p + 1; $i < $right + 1; $i++) {
            $curr_sum += $nums[$i];
            $right_subsum = max($right_subsum, $curr_sum);
        }

        return $left_subsum + $right_subsum;
    }
}


$nums = [-2,1,-3,4,-1,2,1,-5,4];
$max_num = (new solution_53())->execute_divide($nums);
echo $max_num;
