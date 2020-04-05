package leetcode_week03_G20200343040053

import "container/list"

//【94. 二叉树的中序遍历】

//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func inorderTraversal(root *TreeNode) []int {
	ret := make([]int, 0)
	if root == nil {
		return ret
	}
	stack := list.New()
	for root != nil || stack.Len() > 0 {
		for root != nil {
			stack.PushBack(root)
			root = root.Left
		}
		root = stack.Back().Value.(*TreeNode)
		ret = append(ret, root.Val)
		stack.Remove(stack.Back())
		root = root.Right
	}
	return ret
}

//leetcode submit region end(Prohibit modification and deletion)

func inorderTraversalSolution2(root *TreeNode) []int {
	ret := make([]int, 0)
	dfs2TreeIn(root, &ret)
	return ret
}

func dfs2TreeIn(node *TreeNode, ret *[]int) {
	if node != nil {
		dfs2TreeIn(node.Left, ret)
		*ret = append(*ret, node.Val)
		dfs2TreeIn(node.Right, ret)
	}
}