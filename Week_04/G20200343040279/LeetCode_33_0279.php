<?php
class Solution {
	function search($nums, $target) {
		$count = count($nums);
		if ($count == 0) return -1;
		$left = 0;
		$right = $count - 1;
		while ($left <= $right) {
			$mid = $left + floor(($right - $left) / 2);
			if ($nums[$mid] == $target) return $mid;
			if ($nums[$left] <= $nums[$mid]) {
				if ($target >= $nums[$left] && $target < $nums[$mid]) {
					$right = $mid - 1;
				} else {
					$left = $mid + 1;
				}
			} else {
				if ($target <= $nums[$right] && $target > $nums[$mid]) {
					$left = $mid + 1;
				} else {
					$right = $mid + 1;
				}
			}
		}

		return -1;
	}

    function search2($nums, $target) {
        return in_array($target, $nums) ? array_search($target, $nums) : -1;
    }
}