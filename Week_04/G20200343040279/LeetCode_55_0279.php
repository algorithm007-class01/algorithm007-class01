<?php

class Solution{
	function canJump($nums) {
		if (count($nums) <= 0) return true;

		$endPos = count($nums) - 1;
		for ($i = count($nums) - 1; $i >= 0; $i--) {
			if ($nums[$i] + $i > $endPos) {
				$endPos = $i;
			}
		}

		return $endPos;
	}
}