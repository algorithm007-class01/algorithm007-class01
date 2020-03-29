<?php
/**
* 144 给定一个二叉树，返回它的 前序 遍历。
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($value) { $this->val = $value; }
 * }
 */
class Solution {

    /**
     * @param TreeNode $root
     * @return Integer[]
     */
    function preorderTraversal($root) {
        $res = array();
        $res  = $this->helper( $root , $res );
        return $res;
    }

    function helper( $root , &$res ){
        if( $root == null ) {
            return $res;
        }
        $res[] = $root->val;
        $this->helper( $root->left , $res );
        $this->helper( $root->right , $res );
        return $res;
    }
}
?>