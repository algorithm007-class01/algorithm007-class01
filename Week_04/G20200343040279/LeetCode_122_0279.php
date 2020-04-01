<?php

class Solution {
	function maxProfit($prices) {
		$num = 0;
		$i = 0;
		while ($i < count($prices) - 1) {
			if ($prices[$i] < $prices[$i + 1]) {
				$num += $prices[$i + 1] - $prices[$i];
			} else {
				$num += 0;
			}
			$i++;
		}
		return $num;
	}
}