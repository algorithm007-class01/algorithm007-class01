<?php

/**
 * 子集问题回溯法
 */
class Solution {
	function subsets($nums) {
        $res = [];
        $this->dfs($nums, [], 0, $res);
        return $res;
    }

    function dfs($nums, $list, $start, &$res) {
        $res[] = $list;
        for ($i = $start; $i < count($nums); $i++) {
            array_push($list, $nums[$i]);
            $this->dfs($nums, $list, $i + 1, $res);
            array_pop($list);
        }
    }

    function subsets2($nums) {
        if (count($nums) == 0) return [];
        $ans = [[], [$nums[0]]];
        $this->dfs2(1, $nums, $ans);
        return $ans;
    }

    function dfs2($n, $nums, &$ans) {
        if ($n == count($nums)) {
            return;
        }

        $tmpall = [];
        for ($i = 0; $i < count($ans); $i++) {
            $tmp = $ans[$i];
            array_push($tmp, $nums[$n]);
            $tmpall[] = $tmp;
        }

        $ans = array_merge($ans, $tmpall);
        $this->dfs2($n + 1, $nums, $ans);
    }
}