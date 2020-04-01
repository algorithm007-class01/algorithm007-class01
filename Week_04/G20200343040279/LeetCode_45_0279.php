<?php

class Solution{
	function jumMinNumber($nums) {
		$end = 0;
		$max_pos = 0;
		$count = 0;
		for ($i = 0; $i < count($nums) - 1; $i++) {
			$max_pos = max($max_pos, $num[$i] + $i);
			if ($end == $i) {
				$end = $max_pos;
				$count++;
			}
		}
		return $count;
	}
}