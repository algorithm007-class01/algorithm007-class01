<?php

/**
 * 从前序中序构建二叉树
 */
class Solution {
	function buildTree($inorder, $preorder) {
		$this->inorder = $inorder;
		$this->preorder = $preorder;
		$this->inmp = array_flip($inorder);
		return $this->helper(0, count($inorder) - 1);
	}

	private $inmp;
	private $inorder;
	private $preindex = 0;
	private $preorder;

	function helper($instart, $inend) {
		if ($instart > $inend) return null;
		$nodval = $this->preorder[$this->preindex];
		$inindex = $this->inmp[$nodeval];
		$node = new TreeNode($nodeval);
		$this->preindex++;
		$node->left = $this->helper($instart, $inindex - 1);
		$node->right = $this->helper($inindex + 1, $inend);
		return $node;
	}
}