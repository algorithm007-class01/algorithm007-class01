<?php
/**
 * 组合
 */
class Solution{
	function combine($n, $k) {
		$res = [];
		$this->backtrack($n, $k, [], 1, $res);
		return $res;
	}

	function backtrack($n, $k, $list, $level, &$res) {
		if (count($list) == $k) {
			$res[] = $list;
			return;
		}

		for ($i = $level; $n - $i + 1 >= $k - count($list); $i++) {
			$list[] = $i;
			$this->backtrack($n, $k, $list, $i + 1, $res);
			array_pop($list);
		}
	}
}