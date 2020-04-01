<?php

class Solution{
	function leamondeChange($bills) {
		$five = $ten = 0;
		for ($i = 0; $i < count($bills); $i++) {
			if ($bills[$i] == 5) {
				$five++;
				continue;
			}

			if ($bills[$i] == 10) {
				if ($five > 0) {
					$five--;
					$ten++;
				} else return false;
			} else {
				if ($five > 0 && $ten > 0) {
					$five--;
					$ten--;
				} elseif ($five >= 3) {
					$five -= 3;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}