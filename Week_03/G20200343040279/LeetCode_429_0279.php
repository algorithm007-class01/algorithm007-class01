<?php

/**
 * N叉树的层序遍历
 */
class Solution {

	/**
	 * 利用队列方式迭代
	 * @param  [type] $root [description]
	 * @return [type]       [description]
	 */
	function leverNaryTree($root) {
		if (empty($root)) return [];
		$res = [];
		$queue = new SplQueue();
		$queue->enqueue($root);
		while (!$queue->isEmpty()) {
			$len = $queue->count();
			$tmp = [];
			for ($i = 0; $i < $len; $i++) {
				$node = $queue->dequeue();
				$tmp[] = $node->val;
				foreach ($node->children as $key => $child) {
					$queue->enqueue($child);
				}
			}
			$res[] = $tmp;
		}
		return $res;
	}

	/**
	 * 深度优先递归算法
	 * @param  [type] $root [description]
	 * @return [type]       [description]
	 */
	function levelNaryTreeRecur($root) {
		$res = [];
		$this->dfs($root, 0, $res);
		return $res;
	}

	function dfs($node, $depth, &$res) {
		if (empty($root)) return $res;
		if ($depth == count($res)) {
			$res[] = $node->val;
		}

		foreach ($node->children as $value) {
			if (!empty($value)) {
				$this->dfs($value, $depth + 1, $res);
			}
		}
	}
}