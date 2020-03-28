<?php
/**
 *后序遍历二叉树的两种方式
 */
class Solution{
	//递归方式
	function postorderBTree($root) {
		$res = [];
		$this->recursion($root, $res);
		return $res;
	}

	function recursion($node, &$res) {
		if ($node == null) return $res;
		$this->recursion($node->left, $res);
		$this->recursion($node->right, $res);
		$res[] = $node->val;
	}
	//迭代方式
	function postorderBTreeIteration($root) {
		if (empty($root)) return [];
		$outStack = [];
		$stack = [$root];
		$output = [];
		while (count($stack)) {
			$node = array_pop($stack);
			$outStack[] = $node;
			if ($node->left) $stack[] = $node->left;
			if ($node->right) $stack[] = $node->right;
		}

		while ($outStack) {
			$item = array_pop($outStack);
			$output[] = $item->val;
		}
		return $output;
	}
}