package G20200343040043

// 144. 二叉树的前序遍历
// 题目：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
// 给定一个二叉树，返回它的 前序 遍历

// 解法
// 前序遍历：输出父节点再左右叶子节点，递归

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {
	var res []int
	traversal(root, &res)
	return res
}

func traversal(node *TreeNode, res *[]int) {
	if node == nil {
		return
	}
	*res = append(*res, node.Val)
	traversal(node.Left, res)
	traversal(node.Right, res)

}

// times: 1
