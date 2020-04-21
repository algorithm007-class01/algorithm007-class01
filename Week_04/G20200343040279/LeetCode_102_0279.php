<?php

/**
 * 二叉树层序遍历
 */
class Solution {
	function leverOrder($root) {
		$res = [];
		$this->level($root, 0, $res);
		return $res;
	}

	function level($node, $level, &$res) {
		if ($node == null) return $res;
		$res[$level][] = $node->val;
		$level++;
		if ($node->left != null) $this->level($node->left, $level, $res);
		if ($node->right != null) $this->level($node->right, $level, $res);
	}

}