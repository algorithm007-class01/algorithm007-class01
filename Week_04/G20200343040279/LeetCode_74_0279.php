<?php

/**
 * 二分查找
74. 搜索二维矩阵

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。

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