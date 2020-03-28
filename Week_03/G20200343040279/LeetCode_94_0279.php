<?php

/**
 * 中序遍历二叉树的两种方式
 */
class Solution {
	//迭代方式
	function inorderBTreeIteration($root) {
		$arr = $res = [];
		if ($root == null) return $res;
		$cur = $root;
		while ($cur != null || !empty($arr)) {
			if ($cur != null) {
				array_push($arr, $cur);
				$cur = $cur->left;
			} else {
				$cur = array_pop($arr);
				$res[] = $cur->val;
				$cur = $cur->right;
			}
		}
		return $res;
	}
	//递归方式
	function inorderBTree($root) {
		$res = [];
		$this->recursion($root, $res);
		return $res;
	}

	function recursion($node, &$res) {
		if ($node == null) return $res;
		$this->recursion($node->left, $res)
		$res[] = $node->val;
		$this->recursion($node->right, $res)
	}
}