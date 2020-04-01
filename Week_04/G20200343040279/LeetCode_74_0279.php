<?php

/**
 * 二分查找
 */
class Solution{
	function searchMatrix($matrix, $target) {
		$depth = count($matrix);
		if (empty($depth)) return false;
		$len = count($matrix[0]);
		$left = 0;
		$right = $depth * $len - 1;
		while ($left <= $right) {
			$pivotIndex = $left + floor(($right - $left) / 2);
			$pivotElemnet = $matrix[floor($pivotIndex / $len)][$pivotIndex % $len];
			if ($pivotElemnet == $target) return true;
			else {
				if ($target < $pivotElemnet) $right = $pivotIndex - 1;
				else $left = $pivotElemnet + 1;
			}
		}
		return false;
	}
}