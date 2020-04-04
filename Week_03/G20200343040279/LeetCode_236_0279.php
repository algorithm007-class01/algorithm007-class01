<?php

/**
 * 二叉树的最近公共祖先
 */
class Solution {
	function lowestCommonAncestor($root, $p, $q) {
		if (empty($root)) return null;
		if ($root == $p || $root == $q) return $root;
		$left = $this->lowestCommonAncestor($root->left, $p, $q);
		$right = $this->lowestCommonAncestor($root->right, $p, $q);
		if (empty($left)) return $right;
		if (empty($right)) return $left;
		if (!empty($left) && !empty($right)) return $root;
		return null;
	}
}