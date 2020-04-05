<?php

/**
 * 自己写函数实现pow(n, x)
 * fastPow
 */
class Solution {
	function myPow($n, $x) {
		$z = (float) $x;
		if ($x < 0) {
			$n = 1 / $n;
			$z = -$z;
		}
		return $this->fastPow($n, $z);
	}

	function fastPow($n, $z) {
		if ($z == 0) return 1.0;
		$half = $this->fastPow($n, floor($z / 2));
		return (fmod($z, 2) == 0) ? $half * $half : $half * $half * $n;
	}
}