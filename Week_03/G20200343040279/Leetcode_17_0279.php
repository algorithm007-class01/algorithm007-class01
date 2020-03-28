<?php
/**
 *电话号码的字母组合
 *https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
Class Solution {
	/**
	 * 利用队列
	 * @param  [type] $digits [description]
	 * @return [type]         [description]
	 */
	function letterCombination($digits) {
		if (empty($digits)) return [];
		$dic = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "yuv", "wxyz"];
		$res = [''];
		for ($i = 0; $i < strlen($digits); $i++) {
			$cur_digits = $digits[$i];
			while (strlen($res[0]) == $i) {
				$head = array_shift($res);
				$chars = $dic[$cur_digits];
				for ($j = 0; $j < strlen($chars); $j++) {
					$res[] = $head . $chars[$j];
				}
			}
		}
		return $res;
	}

	function letterCombinationRecur($digits) {
		$dic = [
			'2' => ['a', 'b', 'c'],
			'3' => ['d', 'e', 'f'],
			'4' => ['g', 'h', 'i'],
			'5' => ['j', 'k', 'l'],
			'6' => ['m', 'n', 'o'],
			'7' => ['p', 'q', 'r', 's'],
			'8' => ['t', 'u', 'v'],
			'9' => ['w', 'x', 'y', 'z']
		];
		$res = [];
		$this->backtrack('', $digits, $dic, $res);
		return $res;
	}

	function backtrack($str, $next_digits, $dic, &$res) {
		if (empty($next_digits)) {
			$res[] = $str;
		} else {
			foreach ($dic[$next_digits[0]] as $value) {
				$this->backtrack($str . $value, substr($next_digits, 1), $dic, $res);
			}
		}
	}
}

echo json_encode((new Solution())->letterCombination("23")) . PHP_EOL;
echo json_encode((new Solution())->letterCombinationRecur("23")) . PHP_EOL;