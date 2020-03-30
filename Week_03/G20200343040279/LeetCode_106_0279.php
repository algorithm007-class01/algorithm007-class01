<?php
/**
 * 从后序中序构建二叉树
 */
class Solution {
	private $postindex;
	private $inorder;
	private $postorder;
	private $inmp;
	function buildTree($inorder, $postorder) {
		$this->inorder = $inorder;
		$this->postorder = $postorder;
		$this->inmp = array_flip($inorder);
		$this->postindex = count($postorder) - 1;
		return $this->helper(0, count($inorder) - 1);
	}

	function helper($instart, $inend) {
		if ($instart > $inend) return null;
		$nodeval = $this->postorder[$this->postindex];
		$postindex = $this->inmp[$nodeval];
		$node = new TreeNode($nodeval);
		$this->postindex--;
		$node->right  $this->helper($postindex + 1, $inend);
		$node->left = $this->helper($instart, $postindex - 1);
		return $node;
	}
}