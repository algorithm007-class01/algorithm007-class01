<?php
/**
 * 94 给定一个二叉树，返回它的中序 遍历。
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
    function inorderTraversal($root)
    {
        $result = [];
        $this->helper($root, $result);
        return $result;
    }
    /*
    * 递归
    */
    function helper( $root , &$result ) {
        if( $root == null ) {
            return ;
        }
        $this->helper( $root->left , $result );
        $result[] = $root->val;
        $this->helper( $root->right , $result);
    }
    /*
    * 栈
    */
    // function inorderTraversalStack($root)
    // {
    //     $res = array();
    //     $stack = array();
    //     while( $root !=null || !empty( $stack )  ) {
    //         if( $root != null ) {
    //             $stack[] = $root;
    //             $root = $root->left;
    //         }else{
    //             $tmp = array_pop( $stack );
    //             $res[] = $tmp->val;
    //             $root = $tmp->right;
    //         }
    //     }
    //     return $res;
    // }
}
?>