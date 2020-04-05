<?php

/**
 * 前序遍历二叉树
 */
class Solution{
	//========================递归写在两个方法中====================start
	function preorderBTree($root) {
		$res = [];
		if ($root == null) return $res;
		$this->recursion($root, $res);
		return $res;
	}

	function recursion($node, &$res) {
		if ($node == null) return $res;
		$res[] = $node->val;
		$this->recursion($node->right, $res);
		$this->recursion($node->left, $res);
	}
	//========================递归写在两个方法中====================end
	function preorderBTreeIteration($root) {
		if ($root == null) return [];
		$stack = [$root];
		$output = [];
		while (count($stack)) {
			$node = array_pop($stack);
			$output[] = $node->val;
			if ($node->right != null) $stack[] = $node->right;
			if ($node->left != null) $stack[] = $node->left;
		}
		return $output;
	}
	//========================递归写在一个方法中====================start
	public $ans = [];
    function preorderTraversalBTree1($root) {
        if ($root != null) {
            array_push($this->ans, $root->val);
            $this->preorderTraversalBTree1($root->left);
            $this->preorderTraversalBTree1($root->right);
        }
        return $this->ans;
    }
    //========================递归写在一个方法中====================end
    function preorderTraversal($root) {
        if (empty($root)) return [];
        $arr = [$root->val];
        $a = $this->preorderTraversal($root->left);
        $b = $this->preorderTraversal($root->right);
        return array_merge($arr, $a , $b);
    }
}