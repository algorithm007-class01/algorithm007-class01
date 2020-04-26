<?php

/**
 * 二分法求x的平方根
 *
 */
class Solution {
	function mySqrt($x) {
		if ($x <= 1) return $x;
		$l = 1;
		$r = floor($x / 2) + 1;
		while ($l < $r) {
			$mid = $l + floor(($r - $l + 1) / 2);
			if ($mid * $mid == $x) return $mid;
			elseif ($mid * $mid < $x) $l = $mid;
			else {
				$r = $mid - 1;
			}
		}
		return $l;
	}
}