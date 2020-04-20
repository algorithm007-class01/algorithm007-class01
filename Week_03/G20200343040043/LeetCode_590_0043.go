package G20200343040043

// 590. N叉树的后序遍历
// 题目：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
// 给定一个 N 叉树，返回其节点值的后序遍历。

// 解法
// 后序遍历：叶子节点遍历完成再输出父节点，递归

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

type Node struct {
	Val      int
	Children []*Node
}

func postorder(root *Node) []int {
	var res []int
	traversal(root, &res)
	return res

}

func traversal(node *Node, res *[]int) {
	if node == nil {
		return
	}
	for _, c := range node.Children {
		traversal(c, res)
	}
	*res = append(*res, node.Val)

}

// times: 1
