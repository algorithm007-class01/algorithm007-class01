package leetcode_week03_G20200343040053

import "container/list"

//【144. 二叉树的前序遍历】

//给定一个二叉树，返回它的 前序 遍历。
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
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int {
	ret := make([]int, 0)
	if root == nil {
		return ret
	}
	stack := list.New()
	stack.PushBack(root)
	for stack.Len() > 0 {
		node := stack.Back().Value.(*TreeNode)
		stack.Remove(stack.Back())
		ret = append(ret, node.Val)
		if node.Right != nil {
			stack.PushBack(node.Right)
		}
		if node.Left != nil {
			stack.PushBack(node.Left)
		}
	}
	return ret
}

//leetcode submit region end(Prohibit modification and deletion)

func preorderTraversalSolution3(root *TreeNode) []int {
	ret = make([]int, 0)
	dfs2TreePre(root, &ret)
	return ret
}

func dfs2TreePre(node *TreeNode, ret *[]int) {
	if node != nil {
		*ret = append(*ret, node.Val)
		dfs2TreePre(node.Left, ret)
		dfs2TreePre(node.Right, ret)
	}
}

func preorderTraversalSolution4(root *TreeNode) []int {
	ret := make([]int, 0)
	if root == nil {
		return ret
	}
	stack := list.New()
	for root != nil || stack.Len() > 0 {
		for root != nil {
			ret = append(ret, root.Val)
			stack.PushBack(root)
			root = root.Left
		}
		root = stack.Back().Value.(*TreeNode).Right
		stack.Remove(stack.Back())
	}
	return ret
}

//func preorderTraversalSolution2(root *TreeNode) []int {
//	ret := make([]int, 0)
//	if root == nil {
//		return ret
//	}
//	stack := [][]interface{[0, root]} // 具体写法需要研究
//	for stack.Len() > 0 {
//		top := stack.Pop()
//		visited := top[0]
//		node = top[1]
//		if node == nil {
//			continue
//		}
//		if visited == 0 {
//			stack = append(stack, [0, node.Right])
//			stack = append(stack, [0, node.left])
//			stack = append(stack, [1, node])
//		} else {
//			ret = append(ret, node.Val)
//		}
//	}
//	return ret
//}
