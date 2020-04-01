<?php

class Solution{
	/**
	 * 分发饼干
	 * @param  [int[]] $g [children]
	 * @param  [int[]] $s [cookies]
	 * @return [int]    [description]
	 */
	function findContentChildren($g, $s) {
		$i = $j = 0;
		$count = 0;
		sort($g);sort($s);
		while ($i < count($g) && $j < count($s)) {
			if ($g[$i] > $s[$j]) {
				$j++;
			} else {
				$i++;
				$j++;
				$count++;
			}
		}
		return $count;
	}
}