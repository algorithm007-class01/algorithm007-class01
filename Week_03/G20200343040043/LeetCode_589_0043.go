package G20200343040043

// 589. N叉树的前序遍历
// 题目：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
// 给定一个 N 叉树，返回其节点值的后序遍历。

// 解法
// 前序遍历：输出父节点再遍历叶子节点，递归

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

func preorder(root *Node) []int {
	var res []int
	traversal(root, &res)
	return res

}

func traversal(node *Node, res *[]int) {
	if node == nil {
		return
	}
	*res = append(*res, node.Val)

	for _, c := range node.Children {
		traversal(c, res)
	}

}

// times: 1
